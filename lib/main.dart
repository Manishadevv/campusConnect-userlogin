import 'package:flutter/material.dart';
import 'api_service.dart'; // Ensure this is imported

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      home: LoginPage(),
    );
  }
}

class LoginPage extends StatefulWidget {
  @override
  _LoginPageState createState() => _LoginPageState();
}

class _LoginPageState extends State<LoginPage> {
  final TextEditingController rollNoController = TextEditingController();
  final TextEditingController mobileNoController = TextEditingController();
  final ApiService apiService = ApiService(); // Create instance

  void _login() async {
    String rollNo = rollNoController.text;
    String mobileNo = mobileNoController.text;

    bool success = await apiService.login(rollNo, mobileNo);
    if (success) {
      ScaffoldMessenger.of(context).showSnackBar(SnackBar(
        content: Text("Login Successful!"),
        backgroundColor: Colors.green,
      ));
    } else {
      ScaffoldMessenger.of(context).showSnackBar(SnackBar(
        content: Text("Invalid Credentials!"),
        backgroundColor: Colors.red,
      ));
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text("Login")),
      body: Padding(
        padding: EdgeInsets.all(16.0),
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            TextField(
              controller: rollNoController,
              decoration: InputDecoration(labelText: "Roll Number"),
            ),
            TextField(
              controller: mobileNoController,
              decoration: InputDecoration(labelText: "Mobile Number"),
            ),
            SizedBox(height: 20),
            ElevatedButton(
              onPressed: _login,
              child: Text("Login"),
            ),
          ],
        ),
      ),
    );
  }
}
