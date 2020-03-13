import pigpio
import math
from datetime import datetime
from time import sleep

# Transmits on GPIO pin 26, broadcom 37

class PFIR :
    pi = pigpio.pi()
    toggle = 0
    message = '1111'
    def switchToggle():
        if(self.toggle == 0 ):
            self.toggle = 1
        elif (self.toggle == 1):
            self.toggle = 0

    def irsend(message):
        bits =  [message[i//8] & 1 << i%8 != 0 for i in range(len(message) * 8)]        
        print(bits)
        for b in bits:
            if b == True:
                #Transmit 6 cycles of
                
    def carrier(gpio, frequency, micros):
       """
       Generate carrier square wave.
       """
       wf = []
       cycle = 1000.0 / frequency
       cycles = int(round(micros/cycle))
       on = int(round(cycle / 2.0))
       sofar = 0
       for c in range(cycles):
          target = int(round((c+1)*cycle))
          sofar += on
          off = target - sofar
          sofar += off
          wf.append(pigpio.pulse(1<<gpio, 0, on))
          wf.append(pigpio.pulse(0, 1<<gpio, off))
       return wf
    
    
    pi.set_mode(37, pigpio.OUTPUT)
    irsend(message)
