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

  Initially, running the `cd` command and passing no arguments appears to have no effect. However, running the `cd` command from one of the descendent directories (e.g., `~/lecture1/`) provides more insight into the command behavior:

  ```bash
  [user@sahara ~/lecture1]$ cd
  [user@sahara ~]$ 
  ```

  When no arguments are passed to the `cd` command, by default the command changes the current working directory to the root directory (`~/` in this case).

- One argument: Directory

  ```bash
  [user@sahara ~]$ cd lecture1/
  [user@sahara ~/lecture1]$ 
  ```

  Passing the path to a directory when executing the `cd` command will change the current working directory to the indicated directory.

  The argument passed to the `cd` command can be either absolute or relative. Note how the following commands demonstrate the same behavior:


  *Absolute*:

  ```bash
  [user@sahara ~/lecture/messages]$ cd ~/lecture/
  [user@sahara ~/lecture]$ 
  ```

  *Relative*:

  ```bash
  [user@sahara ~/lecture/messages]$ cd ../
  [user@sahara ~/lecture]$ 
  ```

- One argument: File

  ```bash
  [user@sahara ~]$ cd lecture1/messages/en-us.txt
  bash: cd: lecture1/messages/en-us.txt: Not a directory
  ```

  Attempting to change the current working directory to a file by passing to the `cd` command the path to a file will throw an error. The working directory must be a directory, not a file.

### `ls`

- No arguments

  ```bash
  [user@sahara ~]$ ls
  ```

- One argument: Directory

  ```bash
  [user@sahara ~]$ ls lecture1/messages/
  ```

- One argument: File

  ```bash
  [user@sahara ~]$ ls lecture1/Hello.class
  ```

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
