# NASA REST API Client

## 🚀 Overview
This is a simple Java-based REST API client that fetches satellite imagery from NASA's Earth Imagery API. It sends a request to the NASA API and downloads the requested satellite image.

## 📌 Features
- Fetches satellite images based on latitude, longitude, and date.
- Uses Java 11+ `HttpClient` for making API requests.
- Saves the received image locally.
- Alternative implementation using `OkHttp` for more flexibility.

## 🛠️ Prerequisites
- Java 11 or later
- Maven (if using dependencies like `OkHttp`)

## 📂 Project Structure
```
📁 nasa-rest-client
 ├── 📄 src/main/java/NasaRestClient.java
 ├── 📄 pom.xml (if using Maven)
 ├── 📄 README.md
 ├── 📄 nasa_image.png (generated image)
```

## 🚀 How to Run

### 1️⃣ Using Java's `HttpClient`
1. Clone this repository:
   ```sh
   git clone https://github.com/yourusername/nasa-rest-client.git
   cd nasa-rest-client
   ```
2. Compile and run the program:
   ```sh
   javac NasaRestClient.java
   java NasaRestClient
   ```
3. The downloaded image will be saved as `nasa_image.png` in the project directory.

### 2️⃣ Using `OkHttp` (Alternative Approach)
1. Add the following Maven dependency in `pom.xml`:
   ```xml
   <dependency>
       <groupId>com.squareup.okhttp3</groupId>
       <artifactId>okhttp</artifactId>
       <version>4.9.3</version>
   </dependency>
   ```
2. Build and run the project:
   ```sh
   mvn clean compile exec:java
   ```

## 🌍 API Reference
This project uses NASA's **Earth Imagery API**:
🔗 [NASA Earth Imagery API](https://api.nasa.gov/)

**Example API Request:**
```
GET https://api.nasa.gov/planetary/earth/imagery?lon=6.08&lat=44.5&date=2014-02-01&api_key=YOUR_API_KEY
```

