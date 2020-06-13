# ***SUMMARY***

## **Exercise 1**
### *MyQueue class:* 
    1. Using 2 node head and tail to control queue
    2. If the queue is empty, insert newNode into Queue by set head = newNode and tail = newNode
    3. When inserting a newNode, the size variable will increase 1
    4. When inserting a newNode and this Node's point is less than tailNode's point, the newNode will be inserted by using tail.next = newNode and transfer tail to this newNode
    5. When inserting a newNode and this Node's point is greater than headNode's point, the newNode will be inserted by using newNode.next = head and transfer head to this newNode
    6. When inserting a newNode and this Node's point is equal with headNode's point, the newNode will be inserted after head
    7. When inserting a newNode and this Node's point is not belong to case 4, 5 or 6, the node will be inserted by using for loop to find a suitable position for it
## **Exercise 2**
### *MyStack class*
    1. Using String array to store stack
    2. There is a top variable to mark the top of the array and when the stack is empty, the top is equal 1
    3. When pushing a string into the array, the string will insert at top position by using array[top] = data and top increase 1
### *Ex2Manager class*
    1. There are two String to store open tag and close tag
    2. InputStack method will get content which is the whole source code of the source page
    3. Using an array c to search through each char of content
    4. When reaching an open tag, the openTag String will store "<" and search next alphabet char until reaching a char which is not an alphabet, after that, it will add ">" and push openTag to the array of MyStack class
    5. When reaching a close tag whose identification sign is "</", it will add "</" to closeTag string and search next alphabet char until reaching a char which is not an alphabet
    6. closeTag will be replace like: </html> to <html> by replace "</" by "<"
    7. New closeTag will be compared with the top of the array of myStack class, if equals, Pop method will be called to 1 time to delete top openTag, if not equal, Pop method will be called until closeTag = top data 
### *Main class*
    1. The main class has to implement all cases of command-line interface requirements.
    2. Sorting the array of my stack class
    3. Controlling input and output activity
