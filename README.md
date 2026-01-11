# Spring Boot with Bazel

A starter Spring Boot application built with Bazel.

## Project Structure

```
.
├── BUILD                          # Bazel build configuration
├── MODULE.bazel                   # Bazel module dependencies
├── WORKSPACE                      # Bazel workspace
├── src/
│   └── main/
│       ├── java/
│       │   └── org/
│       │       └── app/
│       │           ├── Application.java        # Main Spring Boot application
│       │           ├── Main.java               # Entry point
│       │           └── controller/
│       │               └── HelloController.java # REST controller
│       └── resources/
│           └── application.properties           # Spring Boot configuration
```

## Prerequisites

- Java 11 or later
- Bazel (installed and configured)

## Building

Build the application using Bazel:

```bash
bazel build //:springboot_app
```

## Running

Run the application:

```bash
bazel run //:springboot_app
```

The application will start on port 8080 (default).

## Testing the Application

Once the application is running, you can test the endpoints:

```bash
# Test the hello endpoint
curl http://localhost:8080/

# Test the health endpoint
curl http://localhost:8080/health
```

## Endpoints

- `GET /` - Returns a hello message
- `GET /health` - Returns health status

## Dependencies

The application uses the following main dependencies (managed via `rules_jvm_external` in MODULE.bazel):

- Spring Boot Starter Web
- Spring Boot Autoconfigure
- Spring Framework Core libraries

## Configuration

Application configuration is in `src/main/resources/application.properties`:

- `server.port=8080` - Application port
- `spring.application.name=springboot-app` - Application name

## Adding New Dependencies

To add new Maven dependencies, update the `MODULE.bazel` file in the `maven.install` section.

## Troubleshooting

### Build Errors

If you encounter build errors about missing dependencies, Bazel will suggest the required dependencies. Add them to the `deps` section in the `BUILD` file.

### Port Already in Use

If port 8080 is already in use, change it in `src/main/resources/application.properties`:

```properties
server.port=8081
```

