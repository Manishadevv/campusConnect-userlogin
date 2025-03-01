import 'dart:convert';
import 'package:http/http.dart' as http;

class ApiService {
  static const String baseUrl = "http://localhost:9040/api"; // Update with your backend URL

  Future<bool> login(String rollNo, String mobileNo) async {
    final url = Uri.parse("$baseUrl/login");

    try {
      final response = await http.post(
        url,
        headers: {"Content-Type": "application/json"},
        body: jsonEncode({"rollNo": rollNo, "mobileNo": mobileNo}),
      );

      if (response.statusCode == 200) {
        return true; // Login successful
      } else {
        return false; // Invalid credentials
      }
    } catch (e) {
      print("Error: $e");
      return false;
    }
  }
}
