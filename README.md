# Happy/Experience

Welcome to the Clojure programming assignment for the position as [Clojure Backend Developer](https://careers.timezynk.com/jobs/1358502-clojure-backend-developer-75-100?promotion=284132-trackable-share-link-social-media)!

# Background
Every time someone works with a particular task, they gain experience. If they enjoy doing the task this is a positive experience, but if they don't enjoy it it probably just wears them out. Your job is to analyse data on this using clojure and then given a particular task be able to rank the persons who would most likely want to do the task and do it well.

# Dataset

The dataset consists of CSV files with the following columns:
- **Date**: Date in ISO-8601 format
- **TaskID**: Task ID in ObjectId format
- **PersonID**: Person ID in ObjectId format
- **Rating**: Users rating of the experience from 1 (terrible) to 5 (amazing)

Example:
```
Date,TaskID,PersonID,Rating
2021-10-01;6156dc9dc1f742f8e11aa14d;6156dca47fe5761a20b92b1d;4
2021-10-01;6156dc9dc1f742f8e11aa14d;6156dcb90ba5173d292c9afe;2
```

In this short example two persons have worked with the same task on the same day, one of them giving it a rating of 4 (pretty nice) and the other a rating of 2 (bad).

# Scoring

Each day of experience gives the user a score for a particular task depending on the rating:
- Rating 1 -> Score -2
- Rating 2 -> Score -1
- Rating 3 -> Score 1
- Rating 4 -> Score 2
- Rating 5 -> Score 3

# Input

The program should accept two inputs:
- the first is the filename containing the ratings for previous dates
- the second is a TaskId to evalute the score for

# Output

The program should output a sorted list of PersonID, with the person with the highest score for that task coming first (ie. the most number of positive experiences) down to the person with the lowest score at the bottom. With the example above:

```
$ lein run small-example.csv 6156dc9dc1f742f8e11aa14d
6156dca47fe5761a20b92b1d;2
6156dcb90ba5173d292c9afe;-1
```

# Submitting your code

Fork this repo to get the instructions and example data and then when your assignment is working, send a link over teamtailor.
