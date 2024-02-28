# Lab Report 4

---

## Step 1-3

## Step 4

![Step 4](../assets/report-4/step-4.png)

`$ ssh jal128@ieng6.ucsd.edu`: Logs into the Ieng6 remote machine with the credential `jal128@ieng6.ucsd.edu`.

## Step 5

![Step 5](../assets/report-4/step-5.png)

`$git clone git@github.com:JacobLee23/lab-7.git`: Clones the `JacobLee23/lab-7.git` repository into a new directory via SSH.

## Step 6

![Step 6](../assets/report-4/step-6.png)

`$ bash test.sh`: Executes the `test.sh` shell script using the `bash` command interpreter.

## Step 7

![Step 7a](../assets/report-4/step-7a.png)
![Step 7b](../assets/report-4/step-7b.png)

`$ vim ListExamplesTests.java`: Opens *ListExamplesTests.java* with `vim` in normal mode.

![Step 7c](../assets/report-4/step-7c.png)

`:%s/li, l2/l2, l1/gc` <kbd>ENTER</kbd>: Searches for the string `l1, l2` within the file and replace each instance with the string `l2, l1`, prompting for confirmation before performing each replacement.

![Step 7d](../assets/report-4/step-7d.png)
![Step 7e](../assets/report-4/step-7e.png)

`ny`: Skips the first replacement; Performs the second replacement.

![Step 7f](../assets/report-4/step-7f.png)

`:wq`: Saves the changes made to the file; Exits `vim`.

## Step 8

![Step 8](../assets/report-4/step-8.png)

<kbd>↑</kbd> <kbd>↑</kbd> <kbd>ENTER</kbd>: Executes the command 2 commands back in command execution history, `$ bash test.sh`.

## Step 9

![Step 9b](../assets/report-4/step-9a.png)

`$ git commit -a -m <message>`: Creates a new commit containing all changed files (`-a`), adding the commit to the local repository log under the commit message `<message>` (`-m <message>`).

![Step 9b](../assets/report-4/step-9b.png)

`$ git push`: Updates the commit record of the remote repository with the commit record of the local repository.

---

# Relevant XKCD

![Relevant XKCD](https://imgs.xkcd.com/comics/real_programmers.png)
