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

  When the `cd` command is executed and no arguments are passed, the command changes the current working directory to the root directory (`~/` in this case).

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

  Executing the `cd` command and passing the path to a file attempts to change the current working directory to a file, which is an invalid operation. Since the working directory must be a directory, not a file, the `cd` command throws an error.

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

  Executing the `ls` command and passing the path to a directory will list all the directories and files that are children of the indicated path.

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

  Note that executing `$ ls ./` has the same behavior as executing `ls` and passing no arguments and is the default behavior of the `ls` command.

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

  Executing the `ls` command and passing the path to a file echoes the indicated path, returning an absolute path when an absolute path is given and a relative path when a relative path is given.

### `cat`

- No arguments

  ```bash
  [user@sahara ~]$ cat
  
  ```

  Initially, executing the `cat` command and passing no arguments appears to cause the command to hang indefinitely. However, when no arguments are passed, the `cat` reads from the standard input stream then outputs the contents of the standard input.

  ```bash
  [user@sahara ~]$ cat
  Hello World!    // User Input
  Hello World!    // Command Output

  ```

  The `cat` command continues to read from the standard input and output its contents until the user terminates the command (<kbd>Ctrl</kbd><kbd>C</kbd>/<kbd>Cmd</kbd><kbd>C</kbd>).

- One argument: Directory

  ```bash
  [user@sahara ~]$ cat lecture1/
  cat: lecture1/: Is a directory
  ```

  Executing the `cat` command and passing the path to a directory attempts to read the contents of the directory, which is an invalid operation, and throws an error.

- One argument: File

  ```bash
  [user@sahara ~]$ cat lecture1/README
  To use this program:

  javac Hello.java
  java Hello messages/en-us.txt
  ```

  Executing the `cat` command and passing the path to a file prints the contents of the file. This works with all files, including binary files:

  ```bash
  [user@sahara ~]$ cat lecture1/Hello.class
  ����A2

  java/lang/Object<init>()java/lang/String
  
  
  
  
  java/nio/file/Pathof;(Ljava/lang/String;[Ljava/lang/String;)Ljava/nio/file/Path;
  !java/nio/charset/StandardCharsetsUTF_8Ljava/nio/charse
  t/Charset;
  
  java/nio/file/Files
  readStringB(Ljava/nio/file/Path;Ljava/nio/charset/Charset;)Ljava/lang/String;
   java/lang/SystemoutLjava/io/PrintStream;
  "#$
  %&java/io/PrintStreamprintln(Ljava/lang/String;)V(HelloCodeLineNumberTablemain([Ljava/lang/String;)V
  Exceptions/java/io/IOException
  SourceFile
  Hello.java!')*��*+,)9*2����L�
  ```

---

## Relevant XKCD

![Relevant XKCD](https://www.explainxkcd.com/wiki/images/b/bd/server_problem.png)
