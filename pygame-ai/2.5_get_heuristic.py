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
GRID_MULT = 32

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
            
        # If pygame detects a collision with any wall variable,
        # then set the corresponding sides the the right place.
        for wall in walls:
            if self.rect.colliderect(wall.rect):
                if x == -1:
                    self.rect.left = wall.rect.right
                elif x == 1:
                    self.rect.right = wall.rect.left
                elif y == -1:
                    self.rect.top = wall.rect.bottom
                elif y == 1:
                    self.rect.bottom = wall.rect.top                       
    
    # Initial drawing of the object to the screen
    def draw(self, surface):
        # Has to deal with the color of the squares
        pygame.draw.rect(screen, (200, 0, 0), self.rect)

class Wall(object):
    #Initialize the wall, user can draw walls that no-one can move through
    def __init__(self):
        # Gets mouse position (returns as a tuple)
        location = pygame.mouse.get_pos()
        # Stores information from the tuples into a usable form
        locX = location[0]
        locY = location[1]
        walls.append(self)

        # Takes wall rotation into account. If you want to rotate a placed wall,
        # hold 'r' when you click
        rotation = False
        self.rotation = rotation
        held_key = pygame.key.get_pressed()
        if held_key[pygame.K_r]:
            self.rotation = not rotation

        if self.rotation == False:
            self.rect = pygame.rect.Rect(locX - 50, locY - 5, 100, 10)
        else:
            self.rect = pygame.rect.Rect(locX - 5, locY - 50, 10, 100)

    def draw(self, surface):
        pygame.draw.rect(screen, (100, 100, 100), self.rect)


# This will draw the nodes in a grid, and store them into a list
class Node(object):
    def __init__(self, location):
        self.location = location
        self.X = self.location[0]
        self.Y = self.location[1]

        # if the node has been visited
        self.visited = False
        
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
        print("Heuristic Distance: {}").format(self.H)


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
                location = (x*GRID_MULT + 10, y*GRID_MULT + 10)
                node = Node(location)

        
# Game Loop Variables
# Creates a display screen at the static size created above
screen = pygame.display.set_mode(SCREEN_SIZE)

# Sets the title of the screen
pygame.display.set_caption("Complex AI")

# creates the objects and the control switch of the game loop
player = Player()
follower = Follower()
grid = Grid()
nodes = []
grid.place_nodes()

print("The number of Nodes is {}").format(len(nodes))

walls = []
running = True

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
            # on click, get the heuristic distance from the first node
            nodes[0].get_heuristic()

    # Draw the player to the screen and detect keystrokes
    player.draw(screen)
    player.handle_keys()

    # draw the follower to the screen
    follower.draw(screen)
    follower.artificial_intelligence()

    #draw the wall
    for wall in walls:
        wall.draw(screen)

    # For screenshot purposes draw the first node
    nodes[0].draw(screen)

    # Draw all the nodes
    # This takes forever, and will cause the prgram to run so slowly that
    # it is impossible to do anything else.
    # Took a screenshot for reference of what it looks like.
    for node in nodes:
        pass
        #node.draw(screen)
        #node.get_heuristic()
    
    # flip, or update the display
    pygame.display.update()

    
