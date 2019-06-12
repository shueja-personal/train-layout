import RPi.GPIO as GPIO
from pygame import mixer














def init():
    mixer.init()







def playSound(filename):
    if not mixer.music.get_busy():
        mixer.music.load(filename)
        mixer.music.play()
    
init()
playSound('./Space_Door_Open.wav')
