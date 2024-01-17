## Week 1 Lab Report

![File Hierarchy](https://jacoblee23.github.io/CSE-15L-Lab-Reports/assets/week-1/file-hierarchy.png)

*The content of this lab report will refer to the above file hierarchy.*

***

### `cd`

- No arguments

  ```bash
  [user@sahara ~]$ cd
  [user@sahara ~]$ 
  ```

  Initially, executing the `cd` command and passing no arguments appears to have no effect. However, executing the `cd` command from one of the descendent directories (e.g., `~/lecture1/`) provides more insight into the command behavior:

  ```bash
  [user@sahara ~/lecture1]$ cd
  [user@sahara ~]$ 
  ```

  When the `cd` command is executed and no arguments are passed, by default the command changes the current working directory to the root directory (`~/` in this case).

- One argument: Directory

  ```bash
  [user@sahara ~]$ cd lecture1/
  [user@sahara ~/lecture1]$ 
  ```

  Executing the `cd` command and passing the path to a directory will change the current working directory to the indicated directory.

  The argument passed to the `cd` command can be either absolute or relative. Note how the following commands demonstrate the same behavior:


  *Absolute*:

  ```bash
  [user@sahara ~/lecture1/messages]$ cd ~/lecture/
  [user@sahara ~/lecture1]$ 
  ```

  *Relative*:

  ```bash
  [user@sahara ~/lecture1/messages]$ cd ../
  [user@sahara ~/lecture1]$ 
  ```

- One argument: File

  ```bash
  [user@sahara ~]$ cd lecture1/messages/en-us.txt
  bash: cd: lecture1/messages/en-us.txt: Not a directory
  ```

  Executing the `cd` command and passing the path to a file attempts to change the current working directory to a file, which is an invalid operation. Since the working directory must be a directory, not a file, the `cd` command throws and error.

### `ls`

- No arguments

  ```bash
  [user@sahara ~]$ ls
  lecture1
  [user@sahara ~]$ cd lecture1/
  [user@sahara ~/lecture1]$ ls
  Hello.class  Hello.java  messages  README
  [user@sahara ~]$ cd messages/
  [user@sahara ~/lecture1/messages]$ ls
  en-gb.txt  en-us.txt  es-mx.txt  zh-cn.txt
  ```

  Executing the `ls` command and passing no arguments lists all the directories and files that are children of the current working directory in [ASCIIbetical order](https://www.cs.cmu.edu/~pattis/15-1XX/common/handouts/ascii.html).

- One argument: Directory

  ```bash
  [user@sahara ~]$ ls lecture1/messages/
  ```

  Executing the `ls` command and passing the path to a directory will list all the directories and files that are children of the indicated path. Note that executing `$ ls ./` has the same behavior as executing `ls` and passing no arguments.

  The argument passed to the `ls` command can be either absolute or relative. Note how the following commands demonstrate the same behavior:

  *Absolute*:

  ```bash
  [user@sahara ~/lecture1/messages]$ ls ~/lecture/
  Hello.class  Hello.java  messages  README
  ```

  *Relative*:

  ```bash
  [user@sahara ~/lecture1/messages]$ ls ../
  Hello.class  Hello.java  messages  README
  ```

- One argument: File

  ```bash
  [user@sahara ~]$ ls lecture1/Hello.class
  lecture1/Hello.class
  [user@sahara ~]$ ls lecture1/messages/en-gb.txt
  lecture1/messages/en-gb.txt
  [user@sahara ~]$ cd lecture1/
  [user@sahara ~/lecture1]$ ls messages/en-gb.txt
  messages/en-gb.txt
  [user@sahara ~/lecture1/messages]$ ls ~/lecture1/Hello.class
  /home/lecture1/Hello.class
  ```

  Executing the `ls` command and passing the path to a file will echo the indicated path, returning an absolute path when an absolute path is given and a relative path when a relative path is given.

### `cat`

- No arguments

  ```bash
  [user@sahara ~]$ cat
  ```

- One argument: Directory

  ```bash
  [user@sahara ~]$ cat lecture1/
  ```

- One argument: File

  ```bash
  [user@sahara ~]$ cat lecture1/README
  ```

---

## Relevant XKCD

![Relevant XKCD](https://www.explainxkcd.com/wiki/images/b/bd/server_problem.png)
