from rstr import xeger
N = 300

with open("user.csv", "w") as f:
    f.write("Email, Point\n");
    for i in range(N):
        f.write(xeger(r'[a-z]{5,10}@gmail\.com') + ", " + xeger(r'[1-9][0-9]{0,5}') + "\n")
