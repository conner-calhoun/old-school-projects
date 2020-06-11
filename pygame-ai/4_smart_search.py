import pygame
import math
pygame.init()

# This version now deems the player as a Target, where the follower will
# locate the quickest path to, taking into account the walls placed by the user.

# Static Variables
# using a different screen size (divisible by 32)
SCREEN_SIZE = (480, 640)
BACKGROUND_COLOR = (255, 255,255)
RED = (255, 0, 0)
GRID_MULT = 16

class Player(object):
    # initialized the object (creates the square at the location and size)
    def __init__(self):
        # Rect(x, y, sizeX, sizeY)
        self.rect = pygame.rect.Rect((232, 50, 16, 16))

    # Uses pygame's key listener to execute command if a certain key is pressed
    def handle_keys(self):
        key = pygame.key.get_pressed()

        #These variable help with collision detection
        x = 0
        y = 0

        # Movement constrained to XY axis for ease of collision handling
        if key[pygame.K_a]:
            self.rect.move_ip(-2, 0)
            y = 0
            x = -2
        elif key[pygame.K_d]:
            self.rect.move_ip(2, 0)
            y = 0
            x = 2
        elif key[pygame.K_w]:
            self.rect.move_ip(0, -2)
            x = 0
            y = -2
        elif key[pygame.K_s]:
            self.rect.move_ip(0, 2)
            x = 0
            y = 2
        elif key[pygame.K_z]:
            follower.get_node_area()
        elif key[pygame.K_f]:
            follower.get_location()

        # If pygame detects a collision with any wall variable,
        # then set the corresponding sides the the right place.
        for wall in walls:
            if self.rect.colliderect(wall.rect):
                if x == -2:
                    self.rect.left = wall.rect.right
                elif x == 2:
                    self.rect.right = wall.rect.left
                elif y == -2:
                    self.rect.top = wall.rect.bottom
                elif y == 2:
                    self.rect.bottom = wall.rect.top

    # This will be useful when implementing AI of the other object
    def getLocation(self):
        # When you press 'l' (see handle_keys), will print the location.
        center = self.rect.center
        return center

    # Initial drawing of the object to the screen
    def draw(self, surface):
        # Has to deal with the color of the squares
        pygame.draw.rect(screen, (0, 0, 128), self.rect)
                

class Follower(object):
    # Same as the character object, but a different location
    def __init__(self):
        self.rect = pygame.rect.Rect(232, 580, 16, 16)
        self.move_here = Node(self.rect.center, False)
        self.path = []
        self.closed = []

    # In later programs, this is where I will add some AI related functions
    def artificial_intelligence(self):
        
        # Stores the location of the player
        player_location = player.getLocation()
        # Splits the location into its X and Y coordinates
        playerX = player_location[0]
        playerY = player_location[1]

        # Grab the location of the follower and
        # splits it into x and y coordinates
        # Separate the location into its X & Y coordinates
        location = self.rect.center
        locX = location[0]
        locY = location[1]

        # Create an area in which nodes will be implemented
        self.node_area_x = (locX-24, locX+24)
        self.node_area_y = (locY-24, locY+24)
            
        # If pygame detects a collision with any wall variable,
        # then set the corresponding sides the the right place.
        for wall in walls:
            if self.rect.colliderect(wall.rect):
                self.rect.move_ip(0,0)

        # Checks for the closest node to the player
        # checks if tht node is activated
        # Makes sure that node isn't a wall
        low = 99999
        
        for x in range(len(nodes)):
            for j in range(len(nodes)):
                h = int(nodes[x].get_heuristic())
                if nodes[x].activated:
                    if not nodes[x].wall:
                        if h < low:
                            low = h
                            self.move_here = nodes[x]
                        if h == low:
                            self.move_here = nodes[j]
                            nodes[x].activated = False
                    
                    
        self.rect.move_ip((self.move_here.X - self.rect.x)/16, (self.move_here.Y - self.rect.y)/16)

            
    # Initial drawing of the object to the screen
    def draw(self, surface):
        # Has to deal with the color of the squares
        pygame.draw.rect(screen, (200, 0, 0), self.rect)

    def get_node_area(self):
        print("The node area X is {}\nThe node area Y is {}").format(self.node_area_x, self.node_area_y)

    def which_nodes(self):
        # For each node, check if it is in the area
        # if it is, set activated
        for node in nodes:
            if node.X >= self.node_area_x[0] and node.X <= self.node_area_x[1]:
                if node.Y >= self.node_area_y[0] and node.Y <= self.node_area_y[1]:
                    node.activated = True
                else:
                    node.activated = False
            else:
                node.activated = False

    # For debugging, had trouble getting it to move to the desired node
    def get_location(self):
        fol_loc = self.rect.center
        print("Follower Location: {}").format(fol_loc)

class Wall(object):
    #Initialize the wall, user can draw walls that no-one can move through
    def __init__(self):
        # Gets mouse position (returns as a tuple)
        self.location = pygame.mouse.get_pos()
        # Stores information from the tuples into a usable form
        locX = self.location[0]
        locY = self.location[1]
        walls.append(self)

        # Takes wall rotation into account. If you want to rotate a placed wall,
        # hold 'r' when you click
        rotation = False
        self.rotation = rotation
        held_key = pygame.key.get_pressed()
        if held_key[pygame.K_r]:
            self.rotation = not rotation

        if self.rotation == False:
            self.rect = pygame.rect.Rect(locX - 25, locY, 50, 10)
            node = Node((locX-50,locY+5), True)
            node = Node((locX, locY+5), True)
            node = Node((locX+50, locY+5), True)
        else:
            self.rect = pygame.rect.Rect(locX, locY - 25, 10, 50)
            node = Node((locX-5, locY-50), True)
            node = Node((locX-5, locY), True)
            node = Node((locX-5, locY+50), True)

    def draw(self, surface):
        pygame.draw.rect(screen, (100, 100, 100), self.rect)


# This will draw the nodes in a grid, and store them into a list
class Node(object):
    def __init__(self, location, wall):
        self.location = location
        self.X = self.location[0]
        self.Y = self.location[1]
        self.rect = pygame.rect.Rect(self.X, self.Y, 5, 5)

        # if the node has been visited
        self.activated = False
        if wall:
            self.wall = True
        else:
            self.wall = False
        
        # Add to the nodes list
        nodes.append(self)

    # Do not use unless you want to bog down the program
    def draw(self, surface):
        for node in nodes:
            pygame.draw.circle(screen, (0,200,0), (self.location), 5)

    def get_heuristic(self):
        # Stores the location of the player
        # useful for the straight line heuristic
        player_location = player.getLocation()
        # Splits the location into its X and Y coordinates
        playerX = player_location[0]
        playerY = player_location[1]

        # heuristic or straight line distance to the player
        self.H = math.hypot(playerX - self.X, playerY - self.Y)
        #Used for debug/testing
        #print("Heuristic Distance: {}").format(self.H)
        return self.H

    def is_wall(self):
        
        self.check_area_x = (self.X-16, self.X+16)
        self.check_area_y = (self.Y-16, self.Y+16)

        # For each wall, we want to check if node is in the walls area,
        # if it is, activate it so that we can see it, but
        # mark it as a wall, so we know to avoid it.
        for wall in walls:
            # Getting location and size of wall
            wall_size = wall.rect.size
            wall_location = wall.location
            # These point to the middle
            wallX = wall_location[0]
            wallY = wall_location[1]
            
            if self.activated:
                if wallX >= self.check_area_x[0] and wallX <= self.check_area_x[1]:
                    if wallY >= self.check_area_y[0] and wallY <= self.check_area_y[1]:
                        self.wall = True
                if self.rect.colliderect(wall):
                    self.wall = True

            #print("Wall coordinates: {}, {}").format(wallX, wallY)
            #print("The wall is size: {}\nThe wall is located at: {}").format(wall_size, wall_location)


# The grid will be beneficial for pathfinding
class Grid(object):
    def __init__(self):
        self.screen = SCREEN_SIZE
        self.screenX = self.screen[0]
        self.screenY = self.screen[1]

    def place_nodes(self):
        for y in range(self.screenY//GRID_MULT):
            for x in range(self.screenX//GRID_MULT):
                # print("Placeing node at ({}, {})").format(x*10, y*10)
                location = (x*GRID_MULT, y*GRID_MULT)
                node = Node(location, False)

        
# Game Loop Variables
# Creates a display screen at the static size created above
screen = pygame.display.set_mode(SCREEN_SIZE)

# Sets the title of the screen
pygame.display.set_caption("Complex AI")

# creates the objects and the control switch of the game loop
player = Player()
grid = Grid()
nodes = []
grid.place_nodes()
follower = Follower()

walls = []
running = True

clock = pygame.time.Clock()

# print("Total number of nodes is {}").format(len(nodes))
print("To start follower AI, hold down 'Q'")

# Game Loop
while running:
    # Gives the screen the static color listed (R, G, B)
    screen.fill(BACKGROUND_COLOR)

    # Get events. Pygame has certain events that it can detect, in this case
    # the event is the QUIT event (when you close the program)
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            running = False
            pygame.quit()
        if event.type == pygame.MOUSEBUTTONDOWN:
            Wall()

    # Draw the player to the screen and detect keystrokes
    player.draw(screen)
    player.handle_keys()

    # draw the follower to the screen and activate logic
    follower.draw(screen)

    key = pygame.key.get_pressed()
    if key[pygame.K_q]:
        follower.artificial_intelligence()
        
        # check which nodes are active
        follower.which_nodes()
        
        for node in nodes:
            if node.activated:
                node.is_wall()
                # node.draw(screen)
                node.get_heuristic()

    #draw the wall
    for wall in walls:
        wall.draw(screen)

    # flip, or update the display
    pygame.display.update()

    clock.tick(70)

    
