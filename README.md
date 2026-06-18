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

### Data Management (In Progress)

* CSV File Storage (header-only, awaiting record persistence)
* HistoryManager stub for future save/load functionality
* CSVUtil stub for future CSV read/write operations

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

### Functional Interface / Callback Pattern

```java
@FunctionalInterface
public interface AnalysisCallback {
    void onAnalysisComplete(double score, String riskLevel, String recommendation);
}
```

### Template Method Pattern

```java
public abstract class Activity {
    public abstract double calculateImpact();
}
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

The application uses the following burnout formula, clamped to [0, 100]:

```
score = (studyHours × 6.0)
      - (sleepHours × 3.0)
      - (exerciseHours × 2.0)
      + (assignmentCount × 3.0)
```

Study hours and assignment count increase the burnout score, while sleep and exercise hours decrease it.

### Risk Levels

| Score Range | Risk Level |
| ----------- | ---------- |
| 0 – 29      | Low        |
| 30 – 59     | Moderate   |
| 60 – 79     | High       |
| 80 – 100    | Critical   |

---

## Project Structure

```text
StudentBurnoutAnalyzer/
│
├── src/
│   ├── app/              # Application entry point (Main.java)
│   ├── model/            # Domain classes (Activity hierarchy, DailyRecord)
│   ├── service/          # Business logic (BurnoutCalculator, RecommendationEngine, HistoryManager)
│   ├── exception/        # Custom exceptions (InvalidHoursException)
│   ├── ui/               # GUI components (MainFrame, RecordForm, ResultsPanel, AnalysisFrame, AnalysisCallback)
│   └── util/             # Utilities (ValidationUtil, CSVUtil)
│
├── bin/                  # Compiled .class files
├── data/
│   └── records.csv       # CSV data store (header only, awaiting persistence)
├── docs/
│   └── class-diagram.md  # ASCII UML class diagram
├── .gitignore
└── README.md
```

---

## Implementation Notes

### Activity Hierarchy (Stub)

The `Activity` abstract class and its subclasses (`StudyActivity`, `SleepActivity`, `ExerciseActivity`) define the Template Method pattern structure. Their `calculateImpact()` methods currently return `0.0` and await implementation. The burnout calculation is handled directly by `BurnoutCalculator` using `DailyRecord` fields.

### Recommendation Engine (Stub)

`RecommendationEngine.generateRecommendation()` currently returns a hardcoded string. The method is ready to be extended with risk-level-specific advice based on `DailyRecord` data.

### Data Persistence (Stub)

`HistoryManager` and `CSVUtil` are stubs. The CSV file (`data/records.csv`) contains only a header row. Recording and loading saved entries is not yet implemented.

### AnalysisFrame (Legacy)

`AnalysisFrame` is a secondary window retained for backward compatibility. The main application uses `ResultsPanel` for inline result display.

---

## UML Design

Core Classes:

| Package      | Classes |
|-------------|---------|
| **model**   | `Activity` (abstract), `StudyActivity`, `SleepActivity`, `ExerciseActivity`, `DailyRecord` |
| **service** | `BurnoutCalculator`, `RecommendationEngine`, `HistoryManager` |
| **util**    | `ValidationUtil`, `CSVUtil` |
| **exception** | `InvalidHoursException` |
| **ui**      | `MainFrame`, `RecordForm`, `ResultsPanel`, `AnalysisFrame`, `AnalysisCallback` |
| **app**     | `Main` |

---

## Technologies Used

* Java 21
* Java Swing (Desktop GUI)
* Object-Oriented Programming (Abstraction, Inheritance, Polymorphism, Encapsulation)
* Design Patterns: Template Method (Activity), Observer/Callback (AnalysisCallback)
* CSV File Handling (planned)
* VS Code

---

## How to Build & Run

### Prerequisites

* Java 21 or later
* `java` and `javac` (for building) available on PATH

### Quick Run (JAR)

A pre-built JAR is provided at the project root:

```bash
java -jar StudentBurnoutAnalyzer.jar
```

### Build from Source

```bash
cd StudentBurnoutAnalyzer
javac -d bin src/**/*.java
```

### Run from Compiled Classes

```bash
java -cp bin app.Main
```

---

## Future Enhancements

* Implement Activity subclass `calculateImpact()` methods
* Tailored recommendations per risk level
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
