import random
import matplotlib.pyplot as plt
import numpy as np
import json


def generate_random_point():
    while True:
        x = random.uniform(-1, 1)
        y = random.uniform(-1, 1)
        distance = (x**2 + y**2)**0.5
        if distance <= 1:
            return [x, y]

def append_positions(file_path, xy = [], xy_rev = [], pxy = [], pxy_rev = [], rev = False):
    try:
        with open(file_path, 'r') as file:
            data = json.load(file)
    except FileNotFoundError:
        data = {'x': [], "y" : [], "x_rev" : [], "y_rev" : [], "px" : [], "py" : [], "px_rev" : [], "py_rev" : []}
    
    if rev == True:
        data["x_rev"].extend([xy_rev[0]])
        data["y_rev"].extend([xy_rev[1]])
        data["px_rev"].extend([pxy_rev[0]])
        data["py_rev"].extend([pxy_rev[1]])
    else:
        data['x'].extend([xy[0]])
        data['y'].extend([xy[1]])
        data['px'].extend([pxy[0]])
        data['py'].extend([pxy[1]])
    
    with open(file_path, 'w') as file:
        json.dump(data, file)


def read_slope(file_path, row):
    with open(file_path, 'r') as file:
        data = json.load(file)
        px_ = data['px'][-row]
        py_ = data['py'][-row]

        if(px != 0):
            slope = py_/px_
        else:
            slope = 0
    return slope


# Example usage
file_path = 'H_circularBilliard.json'



def get_position(in_pos, in_mom):
    x,y = in_pos
    px, py = in_mom

    # Calculate the intersection point
    if px == 0:
        if(py > 0):
            next_y = (1 - x**2)**0.5
        elif py < 0:
            next_y = -(1 - x**2)**0.5

        next_x = x

        x_sq = next_x ** 2
        y_sq = next_y ** 2
        px_new = (y_sq - x_sq) * px - 2 * next_x * next_y * py
        py_new = -2 * next_x * next_y * px + (x_sq - y_sq) * py

        # Update position and momentum
        position = [next_x, next_y]
        momentum = [px_new, py_new]

        return (position, momentum)
    else:
        m = py / px  # Slope of the line

    
    k = y - m * x  # y-intercept of the line
    a = 1 + m ** 2
    b = 2 * m * k
    c = k ** 2 - 1

    # Solve quadratic equation to find intersection points
    discriminant = b ** 2 - 4 * a * c
    if discriminant >= 0:
        #print(discriminant)
        x1 = (-b + discriminant ** 0.5) / (2 * a)
        x2 = (-b - discriminant ** 0.5) / (2 * a)

        if px < 0:
            next_x = min(x1, x2)
        else:
            next_x = max(x1,x2)

        next_y = m * next_x + k

        # Determine new momentum after reflection
        x_sq = next_x ** 2
        y_sq = next_y ** 2
        px_new = (y_sq - x_sq) * px - 2 * next_x * next_y * py
        py_new = -2 * next_x * next_y * px + (x_sq - y_sq) * py

        # Update position and momentum
        position = [next_x, next_y]
        momentum = [px_new, py_new]

        return (position, momentum)
    else:
        return "error"

# Run the simulation for a certain number of steps
steps = 4

init_pos = generate_random_point()
init_mom = [random.uniform(-1, 1),random.uniform(-1, 1)]

print("init pos", init_pos)
print("init_mom", init_mom)


circle = plt.Circle((0, 0), radius=1, edgecolor='black', facecolor='none')
fig, ax = plt.subplots()
ax.set_aspect('equal')
ax.add_patch(circle)

#non-reverse
for i in range(steps):
    k = get_position(init_pos, init_mom)
    #print(k)
    x0, y0 = k[0]
    px, py = k[1]
    plt.plot([init_pos[0],x0], [init_pos[1], y0], color='red')
    init_pos = [x0,y0]
    init_mom = [px, py]

    append_positions(file_path, xy = init_pos, pxy = init_mom)


print("reverse __________")

count = 0
delta = 0.01

init_pos_reverse = init_pos.copy()
init_mom_reverse = [-init_mom[0], -init_mom[1]]
#reverse
for j in range(steps + 1):
    k = get_position(init_pos_reverse, init_mom_reverse)
    #print(k)
    x0, y0 = k[0]
    px, py = k[1]
    if(True): # you can turn off the reverse mode here
        plt.plot([init_pos_reverse[0],x0], [init_pos_reverse[1], y0], color='blue')
    init_pos_reverse = [x0,y0]
    init_mom_reverse = [px, py]

    if px != 0 and (py/px - read_slope(file_path, j)) > delta:
        count+=1
    

    append_positions(file_path, xy_rev = init_pos_reverse, pxy_rev = init_mom_reverse, rev = True)


# Set the plot limits
plt.xlim(-1.5, 1.5)
plt.ylim(-1.5, 1.5)

# Add labels and title
plt.xlabel('x')
plt.ylabel('y')
plt.title('Circle and Line')

# Display the plot
plt.grid(True)
plt.show()


# if you don't see the red line then it coincides :)

# the blue line (reverse mode) covers the red line (non reverse mode). you can turn it off in above line 148
