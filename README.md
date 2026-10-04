# Vehicle Tracker Application

A native Android application built with Kotlin and Jetpack Compose that fetches and displays real-time vehicle metrics. The project is engineered using **Clean Architecture** principles and the **MVVM (Model-View-ViewModel)** design pattern to ensure scalability, testability, and a strict separation of concerns.

---

## 🏗️ Architecture Overview

The codebase is strictly segregated into three distinct architectural layers, ensuring that business logic remains completely decoupled from framework dependencies and network implementations.


### 1. Domain Layer (Pure Business Logic)
* **Entities:** Pure Kotlin data classes (e.g., `VehicleDetail`) representing the core business models. Free from network annotations (`@Serializable`) or framework types.
* **UseCases:** Single-responsibility interactors (e.g., `GetVehicleListUseCase`, `GetVehicleDetailUseCase`) that encapsulate distinct execution rules.
* **Repository Contracts:** Interfaces defining data requirements. This acts as the structural boundary separating business logic from infrastructure.

### 2. Data Layer (Infrastructure & Data Source)
* **API Service:** Handles remote network data fetching via **Retrofit** and **Kotlinx Serialization**, operating with raw Data Transfer Objects (`VehicleDetailDto`).
* **Repository Implementation:** Implements the domain repository contracts. It manages an efficient **in-memory data cache** preventing redundant network requests.
* **Mappers:** Pure extension functions (e.g., `toDomain()`) responsible for transforming DTOs into domain models, handling complex transformations such as parsing UTC server strings into local **Kolkata Standard Time (IST) AM/PM formats**.

### 3. UI Layer (Presentation)
* **ViewModels:** State-holders exposed via Compose `State<T>`. Leverages `SavedStateHandle` to cleanly handle configuration changes and parameters.
* **Navigation:** Implements modern, **Type-Safe Compose Navigation (2.8+)**, eliminating string paths and leveraging `@Serializable` route contracts.
* **Composables:** A declarative UI layout built with Jetpack Compose, respecting **Window Insets** (`statusBarsPadding`, `navigationBarsPadding`) for an immersive edge-to-edge layout design.

---

## 🛠️ Tech Stack & Modern Implementations

* **Kotlin Coroutines & Flow:** Asynchronous data streaming from data layers up to UI components.
* **Hilt (Dagger):** Dependency Injection framework automatically managing lifetimes and scopes (`@Singleton`, `@Inject constructor`, `@Binds`).
* **Built-in Kotlin (AGP 9.0+):** Utilizes the modern Android Gradle Plugin architecture for faster compilation without deprecated plugins.
* **JUnit 4 & MockK:** Meaningful unit testing covering time conversions, data mapping transformations, and ViewModel UI state machines.

---

## 🚀 Build and Run Instructions

### Prerequisites
* **Android Studio:** Android Studio Ladybug (2024.2.1) or higher is recommended.
* **JDK:** Java Development Kit (JDK) 17 configured in Android Studio settings.
* **Git:** Git command line tool or Git Bash installed.

### Step 1: Clone the Repository
Open your local terminal or Git Bash and clone the repository:
```bash
git clone https://github.com
cd InterviewTask
```

### Step 2: Open in Android Studio
1. Launch Android Studio.
2. Select **File -> Open** and navigate to the cloned `InterviewTask` folder.
3. Wait for the **Gradle Sync** to finish importing all dependencies automatically.

### Step 3: Run the Application
1. Connect a physical Android device with *USB Debugging* enabled, or start an Android Virtual Device (Emulator).
2. Click the **Run button (Green Play Arrow)** in the top toolbar of Android Studio, or press `Shift + F10`.

### Step 4: Execute Unit Tests
To verify the business logic layers and data mappers against regressions:
* Open the **Terminal** tab at the bottom of Android Studio and execute:
  ```bash
  ./gradlew test
  ```
* Alternatively, right-click the `src/test` directory in the project navigation pane and select **Run 'All Tests'**.

