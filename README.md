# WebClient
A simple Java based web client, using the standard library (JDK/JRE).

## Table of Contents

- [Features](#features)
- [Installation](#installation)
- [Usage](#usage)
- [License](#license)

## Features

- Uses on the Java standard library, no external dependencies
- Simple to use
- Lightweight

## Installation

This may eventually be released on Maven Central or released as an artifact on GitHub. For now, clone the repo and build locally.

### Prequisites

- [Java](https://adoptium.net/)
- [Maven](https://maven.apache.org/)
- [Git](https://git-scm.com/)

1. Clone the repo locally:

```
git clone https://github.com/jbrogers63/webclient
```

2. Build and install locally
```
cd webclient
mvn clean install
```

3. Add dependency to your project's pom.xml:
```xml
<dependency>
  <groupId>jbrogers63</groupId>
  <artifactId>webclient</artifactId>
  <version>0.1.0</version>
</dependency>
```


## Usage

Basic Usage:
```java
import jbrogers63.WebClient;
import java.net.http.HttpResponse;
import java.util.Map;

public class MyWebClient {

    public static void main(String[] args) {
        private WebClient client = new WebClient();
        HttpResponse<String> response = client.get("https://www.example.org", Map.of());

        assert(response.statusCode() == 200);
    }
}
```

Make a JSON request:
```java
import jbrogers63.WebClient;
import jbrogers63.Headers;
import jbrogers63.MediaTypes;

import java.util.Map;
import java.net.http.HttpResponse;

public class MyWebClient {

    public static void main(String[] args) {
        private WebClient client = new WebClient();
        Map<String,String> headers = Map.of(
            Headers.ACCEPT, MediaTypes.APPLICATION_JSON,
            Headers.CONTENT_TYPE, MediaTypes.APPLICATION_JSON
        );

        String body = "{ \"foo\": \"bar\" }";

        HttpResponse<String> response = client.post("https://www.example.org", body, headers);

        assert(response.statusCode() == 200);
        System.out.println(response.body());  // assuming you get a response back...
    }
}
```


## License

This project is licensed under the BSD 3-Clause License.

