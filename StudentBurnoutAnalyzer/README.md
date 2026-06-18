# Student Burnout & Productivity Analyzer

A Java Swing desktop application designed to help students monitor their academic wellness, identify burnout risks, and receive actionable recommendations for maintaining a healthy study-life balance.

## Overview

University students often struggle to balance studying, assignments, sleep, and physical activity. Excessive academic pressure can lead to burnout, reduced productivity, and declining well-being.

The Student Burnout & Productivity Analyzer provides a simple way to evaluate daily habits and calculate a burnout score based on user inputs. The system then determines a risk level and generates personalized recommendations to encourage healthier routines.

---

## Problem Statement

Student burnout is a growing issue in higher education. Many students underestimate the impact of poor sleep, excessive study hours, and lack of exercise on their academic performance and mental well-being.

This application aims to:

* Raise awareness of burnout indicators
* Help students self-assess their daily habits
* Encourage healthier study routines
* Provide early warnings before burnout becomes severe

---

## Features

### Academic Wellness Tracking

* Study Hours Monitoring
* Sleep Hours Tracking
* Exercise Hours Tracking
* Assignment Workload Tracking

### Burnout Analysis

* Burnout Score Calculation
* Risk Level Classification
* Personalized Recommendations
* Warning Notifications

### Data Management

* Save Daily Records
* Load Historical Records
* CSV File Storage

### User Interface

* Java Swing Desktop GUI
* Interactive Input Forms
* Dynamic Analysis Results
* User-Friendly Dashboard

---

## OOP Concepts Demonstrated

### Abstraction

```java
public abstract class Activity
```

### Inheritance

```java
StudyActivity extends Activity
SleepActivity extends Activity
ExerciseActivity extends Activity
```

### Polymorphism

```java
Activity activity = new StudyActivity(5);
activity.calculateImpact();
```

### Method Overloading

```java
calculateBurnout(DailyRecord record)
calculateBurnout(int studyHours)
calculateBurnout(int studyHours, int sleepHours)
```

### Exception Handling

* Input Validation
* Invalid Numeric Values
* Empty Fields
* Custom Exceptions

### Custom Exception

```java
InvalidHoursException
```

---

## Mathematical Model

The application uses a custom burnout formula:

Burnout Score =

(Study Hours × 2.0)
+
(Assignment Count × 1.5)
------------------------

## (Sleep Hours × 1.5)

(Exercise Hours × 1.2)

### Risk Levels

| Score Range | Risk Level |
| ----------- | ---------- |
| 0 - 10      | Low        |
| 11 - 20     | Moderate   |
| 21 - 30     | High       |
| 31+         | Critical   |

---

## Project Structure

```text
StudentBurnoutAnalyzer/
│
├── src/
│   ├── app/
│   ├── model/
│   ├── service/
│   ├── exception/
│   ├── ui/
│   └── util/
│
├── data/
│   └── records.csv
│
├── docs/
│
└── README.md
```

---

## UML Design

Core Classes:

* Activity (Abstract)
* StudyActivity
* SleepActivity
* ExerciseActivity
* DailyRecord
* BurnoutCalculator
* RecommendationEngine
* HistoryManager
* CSVUtil
* ValidationUtil
* InvalidHoursException
* MainFrame
* RecordForm
* AnalysisFrame

---

## Technologies Used

* Java 21
* Java Swing
* Object-Oriented Programming
* CSV File Handling
* VS Code

---

## Future Enhancements

* Weekly Burnout Trend Charts
* Data Visualization Dashboard
* Export Reports to PDF
* Dark Mode
* User Profiles
* Machine Learning Burnout Prediction
* Mobile Version

---

## Real-World Impact

This project demonstrates how software can be used to support student well-being by transforming daily activity data into meaningful insights.

Potential applications include:

* Universities
* Academic Advisors
* Student Support Services
* Personal Productivity Tracking

By helping students recognize unhealthy habits early, the system can contribute to improved academic performance and overall well-being.

---

## Authors

CSF12403 Object-Oriented Programming Project

Built using Java Swing and Object-Oriented Design Principles.
