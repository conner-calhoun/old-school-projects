import pygame
pygame.init()

# Very similar code as the No AI Version, but there is now a wall you can
# create, and there is collision for that wall
# The Follower also has very simple AI

# Static Variables
SCREEN_SIZE = (400, 500)
BACKGROUND_COLOR = (255, 255,255)
RED = (255, 0, 0)

class Player(object):
    # initialized the object (creates the square at the location and size)
    def __init__(self):
        # Rect(x, y, sizeX, sizeY)
        self.rect = pygame.rect.Rect((190, 50, 16, 16))

    # Uses pygame's key listener to execute command if a certain key is pressed
    def handle_keys(self):
        key = pygame.key.get_pressed()

        # These return the direction that the player is moving
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
        self.rect = pygame.rect.Rect(190, 350, 16, 16)

    # In later programs, this is where I will add some AI related functions
    def artificial_intelligence(self):
        player_location = player.getLocation()
        playerX = player_location[0]
        playerY = player_location[1]

        # Separate the location into its X & Y coordinates
        location = self.rect.center
        locX = location[0]
        locY = location[1]

        # These return the direction the follower is moving
        x = 0
        y = 0

        # Doesn't follow very efficiently. Would need
        # another set of conditionals
        if playerX > locX:
            self.rect.move_ip(1, 0)
            y = 0
            x = 1
        elif playerX < locX:
            self.rect.move_ip(-1, 0)
            y = 0
            x = -1
        elif playerY > locY:
            self.rect.move_ip(0, 1)
            x = 0
            y = 1
        elif playerY < locY:
            self.rect.move_ip(0, -1)
            x = 0
            y = -1
            
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
        held_key = pygame.key.get_pressed()
        if held_key[pygame.K_r]:
            rotation = not rotation

        if rotation == False:
            self.rect = pygame.rect.Rect(locX - 50, locY - 5, 100, 10)
        else:
            self.rect = pygame.rect.Rect(locX - 5, locY - 50, 10, 100)

    def draw(self, surface):
        pygame.draw.rect(screen, (100, 100, 100), self.rect)



# Main Game Loop

# Creates a display screen at the static size created above
screen = pygame.display.set_mode(SCREEN_SIZE)

# Sets the title of the screen
pygame.display.set_caption("Simple AI")

# creates the objects and the control switch of the game loop
player = Player()
follower = Follower()
walls = []
running = True

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

    # draw the follower to the screen
    follower.draw(screen)
    follower.artificial_intelligence()

    #draw the wall
    for wall in walls:
        wall.draw(screen)
    
    # flip, or update the display
    pygame.display.update()

    
