// 31. Basic JDBC Connection
// Connect to a local SQLite database and retrieve data from "students" table
import java.sql.*;

class BasicJDBCConnection {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:students.db"; // SQLite file database

        try (Connection conn = DriverManager.getConnection(url)) {
            System.out.println("Connection to SQLite established.");

            String query = "SELECT id, name, age FROM students";
            try (Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(query)) {

                while (rs.next()) {
                    System.out.println("ID: " + rs.getInt("id") +
                                       ", Name: " + rs.getString("name") +
                                       ", Age: " + rs.getInt("age"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

// 32. Insert and Update Operations in JDBC
// StudentDAO with insert and update methods using PreparedStatement
class StudentDAO {
    private final Connection conn;

    public StudentDAO(Connection conn) {
        this.conn = conn;
    }

    public void insertStudent(int id, String name, int age) throws SQLException {
        String sql = "INSERT INTO students (id, name, age) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            pstmt.setInt(3, age);
            pstmt.executeUpdate();
            System.out.println("Student inserted.");
        }
    }

    public void updateStudentAge(int id, int newAge) throws SQLException {
        String sql = "UPDATE students SET age = ? WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, newAge);
            pstmt.setInt(2, id);
            int rows = pstmt.executeUpdate();
            System.out.println(rows > 0 ? "Student age updated." : "Student not found.");
        }
    }

    public static void main(String[] args) {
        String url = "jdbc:sqlite:students.db";
        try (Connection conn = DriverManager.getConnection(url)) {
            StudentDAO dao = new StudentDAO(conn);
            dao.insertStudent(3, "John Doe", 22);
            dao.updateStudentAge(3, 23);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

// 33. Transaction Handling in JDBC
// Simulate money transfer between two accounts
class TransactionDemo {
    public static void transfer(Connection conn, int fromAcc, int toAcc, double amount) throws SQLException {
        try {
            conn.setAutoCommit(false);

            String debitSql = "UPDATE accounts SET balance = balance - ? WHERE id = ?";
            String creditSql = "UPDATE accounts SET balance = balance + ? WHERE id = ?";

            try (PreparedStatement debitStmt = conn.prepareStatement(debitSql);
                 PreparedStatement creditStmt = conn.prepareStatement(creditSql)) {

                debitStmt.setDouble(1, amount);
                debitStmt.setInt(2, fromAcc);
                debitStmt.executeUpdate();

                creditStmt.setDouble(1, amount);
                creditStmt.setInt(2, toAcc);
                creditStmt.executeUpdate();

                conn.commit();
                System.out.println("Transfer successful.");
            }
        } catch (SQLException e) {
            conn.rollback();
            System.out.println("Transfer failed, transaction rolled back.");
            throw e;
        } finally {
            conn.setAutoCommit(true);
        }
    }

    public static void main(String[] args) {
        String url = "jdbc:sqlite:bank.db";
        try (Connection conn = DriverManager.getConnection(url)) {
            transfer(conn, 1, 2, 100.0);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

// 34. Create and Use Java Modules
// Simple utility class to simulate module usage
class Utils {
    public static void printMessage() {
        System.out.println("Hello from com.utils!");
    }
}

class Greetings {
    public static void main(String[] args) {
        Utils.printMessage();
        System.out.println("Greetings from com.greetings!");
    }
}

// 35. TCP Client-Server Chat
// Simple server-client (run separately)
import java.io.*;
import java.net.*;

class ChatServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(5000);
        System.out.println("Server is running...");

        Socket socket = serverSocket.accept();
        System.out.println("Client connected.");

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        out.println("Welcome to server!");
        System.out.println("Client says: " + in.readLine());

        socket.close();
        serverSocket.close();
    }
}

class ChatClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 5000);

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        System.out.println("Server says: " + in.readLine());
        out.println("Hello Server!");

        socket.close();
    }
}

// 36. HTTP Client API (Java 11+)
// Fetch GitHub API using HttpClient
import java.net.http.*;
import java.net.URI;

class HttpExample {
    public static void main(String[] args) throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create("https://api.github.com"))
            .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("Status: " + response.statusCode());
        System.out.println("Body: " + response.body());
    }
}

// 37. Using javap to Inspect Bytecode
// Compile this class and use: javac Hello.java && javap -c Hello
class Hello {
    public static void sayHello() {
        System.out.println("Hello Bytecode!");
    }

    public static void main(String[] args) {
        sayHello();
    }
}

// 38. Decompile a Class File
// Compile and open Hello.class in JD-GUI or CFR
class DecompileExample {
    public static void greet() {
        System.out.println("Decompile this class.");
    }

    public static void main(String[] args) {
        greet();
    }
}

// 39. Reflection in Java
// Load class and invoke method dynamically
import java.lang.reflect.*;

class ReflectionDemo {
    public static void sampleMethod(String msg) {
        System.out.println("Called via reflection: " + msg);
    }

    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName("ReflectionDemo");
        Method[] methods = clazz.getDeclaredMethods();

        for (Method m : methods) {
            System.out.println("Method: " + m.getName());
        }

        Method method = clazz.getDeclaredMethod("sampleMethod", String.class);
        method.invoke(null, "Hello Reflection!");
    }
}

// 40. Virtual Threads (Java 21)
// Launch 100,000 virtual threads (requires Java 21)
class VirtualThreadsExample {
    public static void main(String[] args) {
        for (int i = 0; i < 100000; i++) {
            Thread.startVirtualThread(() -> System.out.println("Running virtual thread: " + Thread.currentThread()));
        }
    }
}

// 41. Executor Service and Callable
// Submit Callable tasks and get results
import java.util.concurrent.*;
import java.util.*;

class ExecutorCallableExample {
    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        List<Callable<String>> tasks = Arrays.asList(
            () -> "Result 1",
            () -> "Result 2",
            () -> "Result 3"
        );

        List<Future<String>> results = executor.invokeAll(tasks);

        for (Future<String> result : results) {
            System.out.println("Result: " + result.get());
        }

        executor.shutdown();
    }
}
