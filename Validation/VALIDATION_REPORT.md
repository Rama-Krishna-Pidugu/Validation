# Form Validation Report – Spring Annotations

## 1. Overview

This report documents form validation on the **User Profile** and **Login** forms using Spring (Jakarta Bean Validation) annotations. The application uses Thymeleaf for views and `spring-boot-starter-validation` for validation.

**How to run:** Start the application and open `http://localhost:8080/` in a browser. Use **User Profile Form** or **Login Form** to test validation.

---

## 2. Annotations Used

| # | Annotation | Message | Used In | Field |
|---|------------|---------|---------|--------|
| 1 | `@NotNull(message = "Field cannot be null")` | Field cannot be null | Profile, Login | username, age, salary |
| 2 | `@NotEmpty(message = "Name cannot be empty")` | Name cannot be empty | Profile | name |
| 3 | `@NotBlank(message = "Password cannot be blank")` | Password cannot be blank | Profile, Login | password |
| 4 | `@Size(min = 3, max = 15, message = "Username must be between 3 and 15 characters")` | Username must be between 3 and 15 characters | Profile, Login | username |
| 5 | `@Min(value = 18, message = "Age must be at least 18")` | Age must be at least 18 | Profile | age |
| 6 | `@Max(value = 65, message = "Age must not exceed 65")` | Age must not exceed 65 | Profile | age |
| 7 | `@Positive(message = "Salary must be positive")` | Salary must be positive | Profile | salary |
| 8 | `@Pattern(regexp = "^[A-Za-z0-9]+$", message = "Only alphanumeric characters are allowed")` | Only alphanumeric characters are allowed | Profile, Login | username |
| 9 | `@Digits(integer = 5, fraction = 2, message = "Number must have up to 5 digits and 2 decimals")` | Number must have up to 5 digits and 2 decimals | Profile | salary |
| 10 | `@AssertTrue(message = "Must accept terms and conditions")` | Must accept terms and conditions | Profile | termsAccepted |

---

## 3. User Profile Form

**URL:** `http://localhost:8080/profile`

### 3.1 Valid Input – Success

| Field | Valid Value |
|-------|-------------|
| Name | John Doe |
| Username | john123 |
| Password | secret123 |
| Age | 25 |
| Salary | 50000.50 |
| Terms | ✓ Checked |

**Expected:** Form submits successfully and shows **Profile saved successfully** with the entered data.

**Screenshot placeholder:** *[Insert screenshot: profile form filled with valid data and success page]*

---

### 3.2 Invalid Inputs – Validation Errors

#### Test 1: Empty name (@NotEmpty)

| Field | Input |
|-------|--------|
| Name | *(empty)* |
| Others | Valid |

**Expected error:** "Name cannot be empty"

**Screenshot placeholder:** *[Insert screenshot: error under Name field]*

---

#### Test 2: Null/empty username (@NotNull, @Size, @Pattern)

| Field | Input | Expected error |
|-------|--------|----------------|
| Username | *(empty)* | Field cannot be null / Username must be between 3 and 15 characters |
| Username | ab | Username must be between 3 and 15 characters |
| Username | user@name | Only alphanumeric characters are allowed |

**Screenshot placeholder:** *[Insert screenshot: username validation errors]*

---

#### Test 3: Blank password (@NotBlank)

| Field | Input |
|-------|--------|
| Password | *(empty or spaces only)* |

**Expected error:** "Password cannot be blank"

**Screenshot placeholder:** *[Insert screenshot: password error]*

---

#### Test 4: Age out of range (@Min, @Max)

| Field | Input | Expected error |
|-------|--------|----------------|
| Age | 17 | Age must be at least 18 |
| Age | 66 | Age must not exceed 65 |
| Age | *(empty)* | Field cannot be null (if applicable) |

**Screenshot placeholder:** *[Insert screenshot: age validation errors]*

---

#### Test 5: Invalid salary (@Positive, @Digits)

| Field | Input | Expected error |
|-------|--------|----------------|
| Salary | 0 or -100 | Salary must be positive |
| Salary | 123456.78 | Number must have up to 5 digits and 2 decimals |
| Salary | 50000.999 | Number must have up to 5 digits and 2 decimals |

**Screenshot placeholder:** *[Insert screenshot: salary validation errors]*

---

#### Test 6: Terms not accepted (@AssertTrue)

| Field | Input |
|-------|--------|
| Terms and conditions | *(unchecked)* |

**Expected error:** "Must accept terms and conditions"

**Screenshot placeholder:** *[Insert screenshot: terms error]*

---

## 4. Login Form

**URL:** `http://localhost:8080/login`

### 4.1 Valid Input – Success

| Field | Valid Value |
|-------|-------------|
| Username | john123 |
| Password | mypass |

**Expected:** "Login successful" page with "Welcome, john123!"

**Screenshot placeholder:** *[Insert screenshot: login form valid submit and success page]*

---

### 4.2 Invalid Inputs – Validation Errors

#### Test 1: Null/empty username

| Field | Input | Expected error |
|-------|--------|----------------|
| Username | *(empty)* | Field cannot be null / Username must be between 3 and 15 characters |

**Screenshot placeholder:** *[Insert screenshot: login username error]*

---

#### Test 2: Username length and pattern

| Field | Input | Expected error |
|-------|--------|----------------|
| Username | ab | Username must be between 3 and 15 characters |
| Username | user-name | Only alphanumeric characters are allowed |

**Screenshot placeholder:** *[Insert screenshot: login username size/pattern errors]*

---

#### Test 3: Blank password (@NotBlank)

| Field | Input |
|-------|--------|
| Password | *(empty or spaces only)* |

**Expected error:** "Password cannot be blank"

**Screenshot placeholder:** *[Insert screenshot: login password error]*

---

## 5. Summary

- **User Profile form** uses all 10 annotations: `@NotNull`, `@NotEmpty`, `@NotBlank`, `@Size`, `@Min`, `@Max`, `@Positive`, `@Pattern`, `@Digits`, `@AssertTrue`.
- **Login form** uses: `@NotNull`, `@NotBlank`, `@Size`, `@Pattern`.
- Validation is triggered by `@Valid` on the controller method parameters; errors are displayed in the Thymeleaf templates via `th:errors`.
- To complete the report, run the application, perform each test case above, and add screenshots in place of the placeholders.

---

## 6. Files Reference

| File | Purpose |
|------|---------|
| `model/UserProfile.java` | User profile model with all 10 validation annotations |
| `model/LoginForm.java` | Login model with @NotNull, @NotBlank, @Size, @Pattern |
| `controller/FormController.java` | GET/POST for `/profile` and `/login` with `@Valid` and `BindingResult` |
| `templates/profile.html` | User profile form with `th:errors` |
| `templates/login.html` | Login form with `th:errors` |
| `templates/profile-result.html` | Success page after valid profile submit |
| `templates/login-result.html` | Success page after valid login submit |
