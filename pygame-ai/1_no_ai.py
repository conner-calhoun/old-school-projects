import pygame
pygame.init()

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
        if key[pygame.K_a]:
           self.rect.move_ip(-2, 0)
        if key[pygame.K_d]:
           self.rect.move_ip(2, 0)
        if key[pygame.K_w]:
           self.rect.move_ip(0, -2)
        if key[pygame.K_s]:
           self.rect.move_ip(0, 2)
        if key[pygame.K_l]:
           self.getLocation()

    # Initial drawing of the object to the screen
    def draw(self, surface):
        # Has to deal with the color of the squares
        pygame.draw.rect(screen, (0, 0, 128), self.rect)

    # This will be useful when implementing AI of the other object
    def getLocation(self):
        # When you press 'l' (see handle_keys), will print the location.
        center = self.rect.center
        print("Location:",center)
                

class Follower(object):
    # Same as the character object, but a different location
    def __init__(self):
        self.rect = pygame.rect.Rect(190, 350, 16, 16)

    # In later programs, this is where I will add some AI related functions
    def artificial_intelligent(self):
        pass

    # Initial drawing of the object to the screen
    def draw(self, surface):
        # Has to deal with the color of the squares
        pygame.draw.rect(screen, (200, 0, 0), self.rect)



# Main Game Loop
# Creates a display screen at the static size created above
screen = pygame.display.set_mode(SCREEN_SIZE)

# Sets the title of the screen
pygame.display.set_caption("No AI")

# creates the objects and the control switch of the game loop
player = Player()
follower = Follower()
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

    # Draw the player to the screen and detect keystrokes
    player.draw(screen)
    player.handle_keys()

    # draw the follower to the screen
    follower.draw(screen)
    
    # flip, or update the display
    pygame.display.update()

    
