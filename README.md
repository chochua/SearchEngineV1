                        Search Engine Project Version 1
                                  Team 3
          
   _____                     _     ______             _         __      ____ 
  / ____|                   | |   |  ____|           (_)        \ \    / /_ |
 | (___   ___  __ _ _ __ ___| |__ | |__   _ __   __ _ _ _ __   __\ \  / / | |
  \___ \ / _ \/ _` | '__/ __| '_ \|  __| | '_ \ / _` | | '_ \ / _ \ \/ /  | |
  ____) |  __/ (_| | | | (__| | | | |____| | | | (_| | | | | |  __/\  /   | |
 |_____/ \___|\__,_|_|  \___|_| |_|______|_| |_|\__, |_|_| |_|\___| \/    |_|
                                                 __/ |                       
                                                |___/                        
------------------------------------------------------------------------------

Allocate:

The allocate class locates the next available space in the disk.

Checkpoint:

used by Allocate to keep track of file space

Storage:

Tells the DiskSpace class what to write, as well as reads from DiskSpace. Uses Allocate to 
find where to write new data. 

DiskSpace:

Writes/reads from the database file.


Known bugs:
The node objects are not cleanly being deserialized, which makes Storage fail its unit testing. 
If given more time, the next path to take would be to make custom readObject() and writeObject() 
methods for the Node class as part of its implementation of Serializable. 
