# Search Engine Project Version 1
## Team 3
Mary Feng, Nicholas Evans, Jacob Sellers, Chong Meng Chua, Nathan Pettorini

### Known Issues
**The node objects are not being correctly deserialized, which makes Storage fail its unit testing. 
If given more time, the next path to take would be to make custom readObject() and writeObject() 
methods for the Node class as part of its implementation of Serializable.**
### Allocate

The Allocate class locates the next available space in the disk.

### Checkpoint

Checkpoint is used by Allocate to keep track of file space

### Storage

Storage tells the DiskSpace class what to write, as well as reads from DiskSpace. Uses Allocate to 
find where to write new data. 

### DiskSpace

DiskSpace writes/reads from the database file.
