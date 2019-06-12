import pigpio
import math
from datetime import datetime
from time import sleep



class PFIR :
    toggle = 0
    currentchannel = 1
    currentMode = "SINGLE_OUT"
    message = ['/0x0']

    def sendIR (self, toggle, channel, mode):
        if(self.toggle == 0 ):
            self.toggle = 1
        elif (self.toggle == 1):
            self.toggle = 0
        currentMode = mode
        currentChannel = channel
        print(toggle, currentChannel, currentMode)
    
    sendIR(self, toggle, 2, "SINGLE_OUT")
    sendIR (self, toggle, 1, "SINGLE_OUT")
           
