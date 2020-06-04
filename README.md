# LAB 1 = SE141026 - VO NGOC KHANG
> **Made from his passion, this is a program uses to solve LAB's problems**

- Problem 1 :smile: : Solved state! :white_check_mark:
- Problem 2 :heart_eyes: : Cool problem! THIS IS WHAT REAL LIFE PROBLEM IS! so i tried to solve it first, and yes successed! but I still found a BUG which i coudn't solve it yet.
 
#### Problem's algorithm:
 - Problem 1: finally understand what he means so i solved it
 	- problem 1 is easy, but the main thing is CACHE! so i asked him this and the final answer is using Serialize!
 - Problem 2: **warning: my alorithm is really strange forward, not optimize it yet of course you can clone this git and try something better! i'm glad you do** 
 
  1. Fetch HTML body using:
	- Connect to that website using [HttpURLConnection](https://docs.oracle.com/javase/8/docs/api/java/net/HttpURLConnection.html) 
	- Set UserAgent to bypass [403 Forbidden Error :x:](https://en.wikipedia.org/wiki/HTTP_403)
    - Get response code  if (200 :white_check_mark:) ==> OK ==>
    - InputStream + BufferRead + StringBuilder to fetch HTML body
  2. Parsing HTML - using to parse TAGs:
 	- For each characters in HTML body:
    	- if current character is **<**:
        	- turn on the collecting characters flag :checkered_flag:
		- if current character is a normal letter:
        	- add it to current incomplete tag 
		- if current character is **>**: (this is a closing tag signal)
        	- turn off the collecting flag :checkered_flag:
            - now we have completely tag :large_blue_diamond:
            - jump to process tag method 
  3. Processing Tag:
    - Lower case tag (prevent ```<A> or <HTmL> or <ScRiPt>```) 
    - If this is a standalone tag (like ```<br> <input>```):
     - put it to CSV data storage, if it exist in CSV data already
       - increase it count (frequencies)
    - else (not a standalone tag):
       - Normalize it: ``` <a href="http://"> ==> <a>```
       - If current tag NOT  contain ```</``` (mean its a open tag):
         - PUSH it to STACK
       - If current tag is close tag:
         - Compare from the top of stack and pop it from stack
         - increase tag's frequencies
       - Else: this is special case, when compare tag is not equal??
         - What should i return? HTML parse failed? nah, i will let this here :confused:
