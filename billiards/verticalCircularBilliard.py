import numpy as np
import matplotlib.pyplot as plt
import json
import random


def generate_random_point():
    while True:
        x = random.uniform(-1, 1)
        y = random.uniform(-1, 1)
        distance = (x**2 + y**2)**0.5
        if distance <= 1:
            return [x, y]
        

def generate_random_mom():
    magnitude = np.random.uniform(5, 10)
    angle = np.random.uniform(0, 2 * np.pi)
    px0 = magnitude * np.cos(angle)
    py0 = magnitude * np.sin(angle)

    return [px0, py0]



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


file_path = 'V_circularBilliard.json'

def simulate_vertical_billiard(init_pos, init_mom, n_ref):
    # Constants
    radius = 1
    g = 10
    # Random initial position inside the circle
    x0, y0 = init_pos

    # Random initial momentum with magnitude between 5 and 10
    px0, py0 = init_mom


    num_reflection = 0
    # Simulate motion
    dt = 0.0001
    x = [x0]
    y = [y0]
    px = [px0]
    py = [py0]

    # for i in range(max_iterations):
    while True:

        if (num_reflection < n_ref):
            # Calculate next position
            next_x = x[-1] + px[-1] * dt
            next_y = y[-1] + py[-1] * dt - 0.5 * g * dt**2

            # Check if next position is outside the circle
            distance = np.sqrt(next_x**2 + next_y**2)
            if distance > radius:

                x_sq = next_x ** 2
                y_sq = next_y ** 2
                px_next = (y_sq - x_sq) * px[-1] - 2 * next_x * next_y * py[-1]
                py_next = -2 * next_x * next_y * px[-1] + (x_sq - y_sq) * py[-1]

                num_reflection+=1
                i = 0
            else:
                # Update momentum due to gravity
                px_next = px[-1]
                py_next = py[-1] - g * dt

            # Append values to the lists
            x.append(next_x)
            y.append(next_y)
            px.append(px_next)
            py.append(py_next)

        else:
            break
    return x, y, px, py

init_pos = generate_random_point()
init_mom = generate_random_mom()

print(init_pos)
print(init_mom)

n = 10
# Run the simulation
x, y, px, py = simulate_vertical_billiard(init_pos, init_mom, n)


init_pos_rev = [x[-1], y[-1]]
init_mom_rev = [-px[-1], -py[-1]]
# Run the simulation in reverse mode
x_rev, y_rev, px_rev, py_rev = simulate_vertical_billiard(init_pos_rev, init_mom_rev, n)

circle = plt.Circle((0, 0), radius=1, edgecolor='black', facecolor='none')
fig, ax = plt.subplots()
ax.set_aspect('equal')
ax.add_patch(circle)

plt.plot(x,y)
plt.plot(x_rev, y_rev)
# Plot the trajectory
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
