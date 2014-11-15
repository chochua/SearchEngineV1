                        Search Engine Project Version 1
                                  Team 3
Members: Mary Feng, Nicholas Evans, Jacob Sellers, Chong Meng Chua, Nathan Pettorini
===================================================================================

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
