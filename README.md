# 🎓 Student Registration - Java Servlet Project

A simple Java Web Application (Servlet + HTML) that collects student registration details via an HTML form and displays a **Registration Successful** confirmation page using a Java Servlet running on Apache Tomcat.

---

## 📸 Project Preview

**Registration Form** → **Successful Registration Page**

| Student Registration Form | Registration Successful Page |
|---|---|
| Fields: First Name, Last Name, Email, Password, Gender, Course, Mobile | Displays all submitted details on success |

---

## 🗂️ Project Structure

```
PracticeProject/
├── src/
│   └── main/
│       └── java/
│           └── com/
│               └── practice/
│                   └── RegistrationServlet.java   ← Java Servlet (backend logic)
├── WebContent/   (or src/main/webapp/)
│   ├── Registration.html                          ← Student Registration Form (frontend)
│   ├── WEB-INF/
│   │   └── web.xml                                ← Servlet mapping configuration
├── pom.xml                                        ← Maven dependencies
└── .classpath                                     ← Eclipse IDE classpath config
```

---

## ✅ Prerequisites

Make sure you have the following installed before running the project:

| Tool | Version | Download Link |
|---|---|---|
| Java JDK | 8 or higher | https://www.oracle.com/java/technologies/downloads/ |
| Apache Tomcat | 9.x or 10.x | https://tomcat.apache.org/download-90.cgi |
| Eclipse IDE (Java EE) | Latest | https://www.eclipse.org/downloads/ |
| Maven (optional) | 3.x | https://maven.apache.org/download.cgi |

---

## 🔧 Step 1 — Install Java JDK

1. Download **JDK 8 or higher** from Oracle's website.
2. Run the installer and follow the steps.
3. Set the `JAVA_HOME` environment variable:
   - Windows: `Control Panel → System → Advanced → Environment Variables`
   - Add new variable: `JAVA_HOME = C:\Program Files\Java\jdk-XX`
   - Add to `PATH`: `%JAVA_HOME%\bin`
4. Verify installation:
   ```bash
   java -version
   javac -version
   ```

---

## 🐱 Step 2 — Install Apache Tomcat

1. Go to: https://tomcat.apache.org/download-90.cgi
2. Under **Binary Distributions → Core**, download the **Windows Service Installer (.exe)** or the **zip** file.
3. Run the installer (or extract the zip) to a folder like `C:\apache-tomcat-9.x`.
4. Set the `CATALINA_HOME` environment variable:
   - `CATALINA_HOME = C:\apache-tomcat-9.x`
5. Start Tomcat:
   - Via installer: It starts automatically as a Windows Service.
   - Via zip: Run `C:\apache-tomcat-9.x\bin\startup.bat`
6. Verify Tomcat is running — open your browser and go to:
   ```
   http://localhost:8080
   ```
   You should see the **Apache Tomcat** welcome page. ✅

---

## 💻 Step 3 — Set Up Project in Eclipse IDE

1. Open **Eclipse IDE for Enterprise Java Developers**.
2. Go to: `File → Import → Existing Maven Projects` (if Maven project) OR `File → Import → Existing Projects into Workspace`.
3. Browse to the **PracticeProject** folder and click **Finish**.
4. Right-click the project → `Properties → Targeted Runtimes` → Select **Apache Tomcat v9.x**.
   - If Tomcat is not listed: Go to `Window → Preferences → Server → Runtime Environments → Add → Apache Tomcat v9.x` and point it to the Tomcat installation folder.

---

## ▶️ Step 4 — Run the Project

### Option A — Run from Eclipse (Recommended)

1. Right-click the project in Eclipse.
2. Select: `Run As → Run on Server`.
3. Choose **Apache Tomcat** and click **Finish**.
4. Eclipse will start Tomcat and open the browser automatically.
5. Navigate to:
   ```
   http://localhost:8080/PracticeProject/Registration.html
   ```

### Option B — Deploy WAR File Manually to Tomcat

1. In Eclipse: Right-click the project → `Export → WAR File` → Save as `PracticeProject.war`.
2. Copy `PracticeProject.war` to:
   ```
   C:\apache-tomcat-9.x\webapps\
   ```
3. Start Tomcat (run `startup.bat`).
4. Tomcat will auto-deploy the WAR file.
5. Open browser and go to:
   ```
   http://localhost:8080/PracticeProject/Registration.html
   ```

---

## 🌐 How to Use the Application

1. Open the registration form:
   ```
   http://localhost:8080/PracticeProject/Registration.html
   ```
2. Fill in the following details:
   - **First Name** — e.g., Chetan
   - **Last Name** — e.g., Banait
   - **Email** — e.g., example@gmail.com
   - **Password** — e.g., q1234567
   - **Gender** — Select Male or Female
   - **Course** — Select from BCA / MCA / BSc / MSc
   - **Mobile Number** — e.g., 7058478975
3. Click the **Register** button.
4. You will be redirected to the **Registration Successful** page at:
   ```
   http://localhost:8080/PracticeProject/RegistrationServlet
   ```
   All submitted details are displayed on screen. ✅

---

## 🛠️ How It Works (Technical Overview)

```
Browser (Registration.html)
       |
       | HTTP POST request
       ↓
RegistrationServlet.java (doPost method)
       |
       | Reads form parameters using request.getParameter()
       | Generates HTML response with student details
       ↓
Browser (Registration Successful page)
```

- **Registration.html** — Contains an HTML form with `action="RegistrationServlet"` and `method="POST"`.
- **RegistrationServlet.java** — Extends `HttpServlet`, overrides `doPost()`, reads parameters, and writes HTML response.
- **web.xml** — Maps the URL pattern `/RegistrationServlet` to the `RegistrationServlet` Java class.

---

## ⚙️ web.xml Servlet Mapping (Reference)

```xml
<web-app>
  <servlet>
    <servlet-name>RegistrationServlet</servlet-name>
    <servlet-class>com.practice.RegistrationServlet</servlet-class>
  </servlet>
  <servlet-mapping>
    <servlet-name>RegistrationServlet</servlet-name>
    <url-pattern>/RegistrationServlet</url-pattern>
  </servlet-mapping>
</web-app>
```

---

## 🐛 Common Issues & Fixes

| Problem | Cause | Fix |
|---|---|---|
| `404 Not Found` | Project not deployed or wrong URL | Check Tomcat is running; verify the URL path |
| `500 Internal Server Error` | Java error in Servlet | Check Eclipse Console / Tomcat logs at `logs/catalina.out` |
| Tomcat port 8080 already in use | Another process using port | Change port in `conf/server.xml` → `<Connector port="8080"` to another port like `8081` |
| Servlet not found | Wrong `web.xml` mapping | Make sure class name and package match exactly in `web.xml` |
| Build errors in Eclipse | Missing Servlet API JAR | Add Tomcat runtime to project build path |

---

## 📦 Maven Dependency (pom.xml)

If using Maven, make sure the Servlet API dependency is included:

```xml
<dependency>
    <groupId>javax.servlet</groupId>
    <artifactId>javax.servlet-api</artifactId>
    <version>4.0.1</version>
    <scope>provided</scope>
</dependency>
```

> `scope=provided` means Tomcat will provide this JAR at runtime — do NOT include it in the WAR file.

---

## 👨‍💻 Author

**Chetan Banait**
QA Engineer | Java Web Development Learner
- Email: chetanbanait30@gmail.com

---

## 📄 License

This project is created for learning and practice purposes.
