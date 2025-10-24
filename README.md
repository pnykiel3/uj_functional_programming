# uj_functional_programming

[assignment 1](https://github.com/pnykiel3/uj_functional_programming/tree/main/assignment1)

## How to View Commit History

To view the complete commit history of this repository, use the following git commands:

### View Basic Commit History
```bash
git log
```

### View Compact One-Line History
```bash
git log --oneline
```

### View History with Graph (shows branches and merges)
```bash
git log --all --graph --oneline
```

### View Detailed History with File Changes
```bash
git log --stat
```

### Access Complete History (if repository was shallow cloned)

If the repository was cloned with limited history (shallow clone), you can fetch the complete history:

```bash
git fetch --unshallow
```

After unshallowing, all the above commands will show the complete commit history.
