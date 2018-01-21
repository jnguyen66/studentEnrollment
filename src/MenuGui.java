//Title: Student Enrollment
//Author: Justin Nguyen
//Class: CS 990

import java.awt.*;
import java.io.*;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.util.Scanner;
import java.util.Scanner;

public class MenuGui extends JFrame {

	private JFrame frame;
	// Creates linked list for student,course, and enrollment info
	MyGenericList<Student> studentList = new MyGenericList<>();
	MyGenericList<Courses> courseList = new MyGenericList<>();
	MyGenericList<EnrollmentInfo> enrollmentList = new MyGenericList<>();
	

	public static void main(String[] args) throws IOException {
		
		
		// Lauches MenuGui
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuGui window = new MenuGui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public MenuGui() {
		initialize();
		load();
	}

	//Loads binary files
	private void load(){
		try {
			File file = new File("studentInfo.bin");
			FileInputStream f;
			f = new FileInputStream(file);
			ObjectInputStream s = new ObjectInputStream(f);
			@SuppressWarnings("unchecked")
			MyGenericList<Student> fileObj2 = (MyGenericList<Student>) s.readObject();;
			
			for (int i = 0; i < fileObj2.size(); i++) {
				// Acquires student id of each node on list
				Student student =fileObj2.get(i);
				// Compares acquired id to user enter id
				studentList.add(student);
				}
			s.close();

		} catch (FileNotFoundException x) {
			System.out.println("Error: File not Found");
		} catch (IOException x) {
			 x.printStackTrace(System.out);
		} catch (ClassNotFoundException x) {
			System.out.println("Error: Class not Found");
		}
		
		try {
			File file = new File("courseInfo.bin");
			FileInputStream f;
			f = new FileInputStream(file);
			ObjectInputStream s = new ObjectInputStream(f);
			@SuppressWarnings("unchecked")
			MyGenericList<Courses> fileObj2 = (MyGenericList<Courses>) s.readObject();;
			s.close();
			for (int i = 0; i < fileObj2.size(); i++) {
				// Acquires student id of each node on list
				Courses course =fileObj2.get(i);
				// Compares acquired id to user enter id
				courseList.add(course);
				}
		} catch (FileNotFoundException x) {
			System.out.println("Error: File not Found");
		} catch (IOException x) {
			System.out.println("Error: Class Error");
		} catch (ClassNotFoundException x) {
			System.out.println("Error: Class not Found");
		}
		
		try {
			File file = new File("enrollmentInfo.bin");
			FileInputStream f;
			f = new FileInputStream(file);
			ObjectInputStream s = new ObjectInputStream(f);
			@SuppressWarnings("unchecked")
			MyGenericList<EnrollmentInfo> fileObj2 = (MyGenericList<EnrollmentInfo>) s.readObject();;
			s.close();
			for (int i = 0; i < fileObj2.size(); i++) {
				// Acquires student id of each node on list
				EnrollmentInfo enroll =fileObj2.get(i);
				// Compares acquired id to user enter id
				enrollmentList.add(enroll);
				}
		} catch (FileNotFoundException x) {
			System.out.println("Error: File not Found");
		} catch (IOException x) {
			System.out.println("Error: Class Error");
		} catch (ClassNotFoundException x) {
			System.out.println("Error: Class not Found");
		}
		
		
	}

	private void initialize() {
		
		// Creates Frame and buttons with their respective action listeners
		frame = new JFrame();
		frame.setBounds(100, 100, 538, 438);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnUpdate = new JButton("Update");
		JComboBox<String> comboBox = new JComboBox<String>();
		JButton btnEditStudent = new JButton("Edit Student");
		JButton btnEditCourse = new JButton("Edit Course");
		
		JTextArea txtReports = new JTextArea();
		JScrollPane scroll = new JScrollPane (txtReports);
		scroll.setBounds(16, 268, 505, 142);
		frame.getContentPane().add(scroll);
		scroll.setVisible(false);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(373, 228, 117, 29);
		frame.getContentPane().add(btnCancel);
		btnCancel.setVisible(false);
		
		JTextArea txtId = new JTextArea();
		txtId.setBounds(142, 105, 175, 20);
		frame.getContentPane().add(txtId);
		txtId.setVisible(false);
		
		JLabel lblStudentEnroll = new JLabel("Select Student For Enrollment");
		lblStudentEnroll.setBounds(16, 70, 204, 16);
		frame.getContentPane().add(lblStudentEnroll);
		lblStudentEnroll.setVisible(false);
		
		JComboBox cbo2 = new JComboBox();
		cbo2.setBounds(329, 101, 203, 27);
		frame.getContentPane().add(cbo2);
		cbo2.setVisible(false);
		
		JComboBox cbo3 = new JComboBox();
		cbo3.setBounds(329, 130, 203, 27);
		frame.getContentPane().add(cbo3);
		cbo3.setVisible(false);
		
		JComboBox cbo4 = new JComboBox();
		cbo4.setBounds(329, 164, 203, 27);
		frame.getContentPane().add(cbo4);
		cbo4.setVisible(false);
		
		JComboBox cbo5 = new JComboBox();
		cbo5.setBounds(329, 203, 203, 27);
		frame.getContentPane().add(cbo5);
		cbo5.setVisible(false);
		
		JLabel lblId = new JLabel("Id");
		lblId.setBounds(16, 105, 114, 16);
		frame.getContentPane().add(lblId);
		lblId.setVisible(false);
		
		JLabel lblFirst = new JLabel("First");
		lblFirst.setBounds(16, 134, 117, 16);
		frame.getContentPane().add(lblFirst);
		lblFirst.setVisible(false);
		
		JLabel lblSecond = new JLabel("Last");
		lblSecond.setBounds(16, 168, 95, 16);
		frame.getContentPane().add(lblSecond);
		lblSecond.setVisible(false);
		
		JLabel lblThird = new JLabel("New label");
		lblThird.setBounds(16, 207, 114, 16);
		frame.getContentPane().add(lblThird);
		lblThird.setVisible(false);
		
		JTextArea txtFirst = new JTextArea();
		txtFirst.setBounds(142, 134, 175, 20);
		frame.getContentPane().add(txtFirst);
		txtFirst.setVisible(false);
		
		JTextArea txtSecond = new JTextArea();
		txtSecond.setBounds(142, 168, 175, 20);
		frame.getContentPane().add(txtSecond);
		txtSecond.setVisible(false);
		
		JTextArea txtThird = new JTextArea();
		txtThird.setBounds(142, 202, 175, 20);
		frame.getContentPane().add(txtThird);
		txtThird.setVisible(false);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(276, 66, 256, 27);
		frame.getContentPane().add(comboBox_1);
		comboBox_1.setVisible(false);

		//Adds student or course depending on selected item
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object selected = comboBox.getSelectedItem();
				if (selected.toString().equals("Enter Student Info")) {
					boolean blnExists = true;
					// Loops thru student list
					String studentId=txtId.getText();
					for (int i = 0; i < studentList.size(); i++) {
						// Acquires student id of each node on list
						String editId = studentList.get(i).getId();
						// Compares acquired id to user enter id
						if (studentId.equals(editId)) {
							// If found makes boolean false, unable to add student
							blnExists = false;
						}
					}
				
				
				if(blnExists){
					//create new student in list
					//and save to binary file
					studentList.add(new Student(txtId.getText(), txtFirst.getText(), txtSecond.getText() , txtThird.getText()  ));
					studentList.sort();
					try {
						File file = new File("studentInfo.bin");
						FileOutputStream f = new FileOutputStream(file, false);
						ObjectOutputStream oos = new ObjectOutputStream(f);
						oos.writeObject(studentList);
						oos.close();
						JOptionPane.showMessageDialog(frame, "Student Added");
					} catch (IOException i) {
						i.printStackTrace();
					}
					btnAdd.setVisible(false);
					lblFirst.setVisible(false);
					lblSecond.setVisible(false);
					txtFirst.setVisible(false);
					txtSecond.setVisible(false);
					btnAdd.setVisible(false);
					txtId.setVisible(false);
					lblId.setVisible(false);
					txtThird.setVisible(false);
					lblThird.setVisible(false);
					btnCancel.setVisible(false);
				}
				else{
					JOptionPane.showMessageDialog(frame, "Student id unavailible. Please select a different ID.");
				}
				} else if (selected.toString().equals("Enter Course Information")) {
					boolean blnExists = true;
					// Loops thru course list
					String courseId=txtId.getText();
					for (int i = 0; i < courseList.size(); i++) {
						// Acquires course id of each node on list
						String editId = courseList.get(i).getId();
						// Compares acquired id to user enter id
						if (courseId.equals(editId)) {
							// If found makes boolean false, unable to add student
							blnExists = false;
						}
					}
				
				if(blnExists){
					//if exists create new course, add to list, 
					//and save to binary file
					courseList.add(new Courses(txtId.getText(), txtFirst.getText(), txtSecond.getText() , txtThird.getText() ));
					courseList.sort();
					try {
						File file = new File("courseInfo.bin");
						FileOutputStream f = new FileOutputStream(file, false);
						ObjectOutputStream oos = new ObjectOutputStream(f);
						oos.writeObject(courseList);
						oos.close();
						JOptionPane.showMessageDialog(frame, "Course Added");
					} catch (IOException i) {
						i.printStackTrace();
					}
					btnAdd.setVisible(false);
					lblFirst.setVisible(false);
					lblSecond.setVisible(false);
					txtFirst.setVisible(false);
					txtSecond.setVisible(false);
					btnAdd.setVisible(false);
					txtId.setVisible(false);
					lblId.setVisible(false);
					txtThird.setVisible(false);
					lblThird.setVisible(false);
				}
				else{
					JOptionPane.showMessageDialog(frame, "Course id unavailible. Please select a different ID.");
				}
					
				}
				
				
				
			}
		});
		btnAdd.setBounds(80, 228, 117, 29);
		frame.getContentPane().add(btnAdd);
		btnAdd.setVisible(false);
		
		//provides a list of all existing students
		JButton btnViewStudent = new JButton("View Student");
		btnViewStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCancel.setVisible(true);
				btnUpdate.setVisible(false);
				btnEditStudent.setVisible(true);
				btnAdd.setVisible(false);
				lblFirst.setVisible(false);
				lblSecond.setVisible(false);
				txtFirst.setVisible(false);
				txtSecond.setVisible(false);
				btnAdd.setVisible(false);
				txtId.setVisible(false);
				lblId.setVisible(false);
				txtThird.setVisible(false);
				lblThird.setVisible(false);
				comboBox_1.removeAllItems();
				comboBox_1.setVisible(true);
				for(int i = 0; i < studentList.size(); i++)
					comboBox_1.addItem(studentList.get(i));
			}
		});
		btnViewStudent.setBounds(162, 37, 136, 29);
		frame.getContentPane().add(btnViewStudent);
		btnViewStudent.setVisible(false);

		//displays add student panel
		JButton btnAddStudent = new JButton("Add Student Info");
		btnAddStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCancel.setVisible(true);
				btnUpdate.setVisible(false);
				comboBox_1.setVisible(false);
				btnEditStudent.setVisible(false);
				lblId.setText("Student Id");
				lblId.setVisible(true);
				txtId.setText(" ");
				txtId.setVisible(true);
				txtId.setEditable(true);
				lblFirst.setText("First Name");
				lblFirst.setVisible(true);
				txtFirst.setText(" ");
				txtFirst.setVisible(true);
				lblSecond.setText("Last Name");
				lblSecond.setVisible(true);
				txtSecond.setText(" ");	
				txtSecond.setVisible(true);
				lblThird.setText("Birthday");
				lblThird.setVisible(true);
				txtThird.setText(" ");
				txtThird.setVisible(true);
				btnAdd.setVisible(true);
				//addStudent();
			}
		});
		btnAddStudent.setBounds(16, 37, 134, 29);
		frame.getContentPane().add(btnAddStudent);
		btnAddStudent.setVisible(false);

		//updates student or course info, add enrollment info, and adds grade
		btnUpdate.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				Object selected = comboBox.getSelectedItem();
				if (selected.toString().equals("Enter Student Info")) {
					String studentId=txtId.getText();
					for (int i = 0; i < studentList.size(); i++) {
						// Acquires student id of each node on list
						String editId = studentList.get(i).getId();
						// Compares acquired id to user enter id
						if (studentId.equals(editId)) {
							// If found removes node 
							studentList.remove(i);
							studentList.add(new Student(txtId.getText(), txtFirst.getText(), txtSecond.getText() , txtThird.getText()));
						}
					}
					studentList.sort();
					try {
						File file = new File("studentInfo.bin");
						FileOutputStream f = new FileOutputStream(file, false);
						ObjectOutputStream oos = new ObjectOutputStream(f);
						oos.writeObject(studentList);
						oos.close();
						btnUpdate.setVisible(false);
						lblFirst.setVisible(false);
						lblSecond.setVisible(false);
						txtFirst.setVisible(false);
						txtSecond.setVisible(false);
						txtId.setVisible(false);
						lblId.setVisible(false);
						txtThird.setVisible(false);
						lblThird.setVisible(false);
						JOptionPane.showMessageDialog(frame, "Update Complete");
					} catch (IOException i) {
						i.printStackTrace();
					}
				
				} else if (selected.toString().equals("Enter Course Information")) {
					String courseId=txtId.getText();
					for (int i = 0; i < courseList.size(); i++) {
						// Acquires course id of each node on list
						String editId = courseList.get(i).getId();
						// Compares acquired id to user enter id
						if (courseId.equals(editId)) {
							// If found removes node and sets boolean to true
							courseList.remove(i);
							courseList.add(new Courses(txtId.getText(), txtFirst.getText(), txtSecond.getText() , txtThird.getText()));
						}
					}
					courseList.sort();
					//save list to binary file
					try {
						File file = new File("courseInfo.bin");
						FileOutputStream f = new FileOutputStream(file, false);
						ObjectOutputStream oos = new ObjectOutputStream(f);
						oos.writeObject(courseList);
						oos.close();
						btnUpdate.setVisible(false);
						lblFirst.setVisible(false);
						lblSecond.setVisible(false);
						txtFirst.setVisible(false);
						txtSecond.setVisible(false);
						txtId.setVisible(false);
						lblId.setVisible(false);
						txtThird.setVisible(false);
						lblThird.setVisible(false);
						JOptionPane.showMessageDialog(frame, "Update Complete");
					} catch (IOException i) {
						i.printStackTrace();
					}
					}else if (selected.toString().equals("Enter Enrollment Information")) {
						boolean stop=false, blnExists=true;
						int gradeMark=0;
						Student gradeStudent =(Student) comboBox_1.getSelectedItem();
						String studentId=gradeStudent.getId();

						Courses gradeCourse =(Courses) cbo2.getSelectedItem();
						String courseId=gradeCourse.getId();
						
						String year=(String) cbo4.getSelectedItem();
						String semester=(String) cbo3.getSelectedItem();
						
						for (int i = 0; i < enrollmentList.size() && !stop; i++) {
							// Acquires student id of each node on list
							String gradeId = enrollmentList.get(i).getStudent().getId();
							// Compares acquired id to user enter id													
							if (studentId.equals(gradeId)) {
								
								// Acquires course id of each node on list
								String gradeCourseId = enrollmentList.get(i).getCourse().getId();
								// Compares acquired id to user enter id															
								if (courseId.equals(gradeCourseId)) {
								
									// Acquires grade year of each node on list
									String gradeYear = enrollmentList.get(i).getYear();	
									// Compares acquired year to user enter year
	
									if (year.equals(gradeYear)) {
										
										String gradeSemester = enrollmentList.get(i).getSemester();									
										if (semester.equals(gradeSemester)) {
										
											//if everything checks out, makes boolean true
											blnExists = false;
											gradeMark=i;
											stop=true;
										}
									}
								}		
							}
						}
						
						if (blnExists) {
								//Set grade to that specific enrollment
							enrollmentList.add(new EnrollmentInfo((Student) comboBox_1.getSelectedItem(), (Courses) cbo2.getSelectedItem(), (String) cbo3.getSelectedItem(), (String) cbo4.getSelectedItem()));
								//Updates binary file
								try {
									File file = new File("enrollmentInfo.bin");
									FileOutputStream f = new FileOutputStream(file, false);
									ObjectOutputStream oos = new ObjectOutputStream(f);
									oos.writeObject(enrollmentList);
									oos.close();
									JOptionPane.showMessageDialog(frame, "Enrollment Completed");
								} catch (IOException i) {
									i.printStackTrace();
								}
					
						}else{
							JOptionPane.showMessageDialog(frame, "Error: Enrollment Entry Already Exists");
						}
						
						System.out.println(enrollmentList);
						
						//save the new one
						//to the binary file
					}else if (selected.toString().equals("Grade Management")) {
						boolean stop=false, blnExists=false;
						int gradeMark=0;
						Student gradeStudent =(Student) comboBox_1.getSelectedItem();
						String studentId=gradeStudent.getId();

						Courses gradeCourse =(Courses) cbo2.getSelectedItem();
						String courseId=gradeCourse.getId();
						
						String year=(String) cbo4.getSelectedItem();
						String semester=(String) cbo3.getSelectedItem();
						
						for (int i = 0; i < enrollmentList.size() && !stop; i++) {
							// Acquires student id of each node on list
							String gradeId = enrollmentList.get(i).getStudent().getId();
							// Compares acquired id to user enter id													
							if (studentId.equals(gradeId)) {
								
								// Acquires course id of each node on list
								String gradeCourseId = enrollmentList.get(i).getCourse().getId();
								// Compares acquired id to user enter id															
								if (courseId.equals(gradeCourseId)) {
								
									// Acquires grade year of each node on list
									String gradeYear = enrollmentList.get(i).getYear();	
									// Compares acquired year to user enter year
	
									if (year.equals(gradeYear)) {
										
										String gradeSemester = enrollmentList.get(i).getSemester();									
										if (semester.equals(gradeSemester)) {
										
											//if everything checks out, makes boolean true
											blnExists = true;
											gradeMark=i;
											stop=true;
										}
									}
								}		
							}
						}
						
						if (blnExists) {
							//Ask user for grade
						
								//Set grade to that specific enrollment
								enrollmentList.get(gradeMark).setGrade((String) cbo5.getSelectedItem());
								//Updates binary file
								try {
									File file = new File("enrollmentInfo.bin");
									FileOutputStream f = new FileOutputStream(file, false);
									ObjectOutputStream oos = new ObjectOutputStream(f);
									oos.writeObject(enrollmentList);
									oos.close();
									JOptionPane.showMessageDialog(frame, "Grade Entered");
								} catch (IOException i) {
									i.printStackTrace();
								}
					
						}else{
							JOptionPane.showMessageDialog(frame, "Error: Specified Enrollment Entry Does Not Exist");
						}
						} else if (selected.toString().equals("Reports")) {
							//create reports generic list
							MyGenericList<EnrollmentInfo> gradeReports = new MyGenericList<>();
							int x = -1;
							//get selected course
							Courses reportCourse =(Courses) comboBox_1.getSelectedItem();
							//get course id
							String reportId=reportCourse.getId();
							//get year
							String year = (String) cbo2.getSelectedItem();
											for (int i = 0; i < enrollmentList.size(); i++) {
												//loop thru enrollment list, and get course
												Courses courseReport = enrollmentList.get(i).getCourse();
												//get course id
												String idReport=courseReport.getId();
												//compare ids
												if (reportId.equals(idReport)) {
													//loop thru list and get year
													String yearReport = enrollmentList.get(i).getYear();
													//compare with user entered year
													if (year.equals(yearReport)) {
														//if equals add enrollment entry to reports
													gradeReports.add(enrollmentList.get(i));
													}
												}
											}
											txtReports.setText(gradeReports.toString());
											scroll.setVisible(true);						
						}
				
			}
		});
		btnUpdate.setBounds(198, 228, 175, 29);
		frame.getContentPane().add(btnUpdate);
		btnUpdate.setVisible(false);
		
		//Edit Student button
		btnEditStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCancel.setVisible(true);
				comboBox_1.setVisible(false);
				Student x=(Student) comboBox_1.getSelectedItem();
				lblId.setText("Student Id");
				lblId.setVisible(true);
				txtId.setText(x.getId());
				txtId.setEditable(false);
				txtId.setVisible(true);
				lblFirst.setText("First Name");
				lblFirst.setVisible(true);
				txtFirst.setText(x.getName());
				txtFirst.setVisible(true);
				lblSecond.setText("Last Name");
				lblSecond.setVisible(true);
				txtSecond.setText(x.getLastName());	
				txtSecond.setVisible(true);
				lblThird.setText("Birthday");
				lblThird.setVisible(true);
				txtThird.setText(x.getBirthday());
				txtThird.setVisible(true);
				btnAdd.setVisible(false);
				btnUpdate.setVisible(true);
				//editStudent();
				
				
			}
		});
		btnEditStudent.setBounds(326, 37, 102, 29);
		frame.getContentPane().add(btnEditStudent);
		btnEditStudent.setVisible(false);

		//displays add course panel
		JButton btnAddCourseInfo = new JButton("Add Course Info");
		btnAddCourseInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCancel.setVisible(true);
				btnUpdate.setVisible(false);
				comboBox_1.setVisible(false);
				btnEditCourse.setVisible(false);
				btnEditStudent.setVisible(false);
				lblId.setText("Course Id");
				lblId.setVisible(true);
				txtId.setText(" ");
				txtId.setVisible(true);
				txtId.setEditable(true);
				lblFirst.setText("Course Name");
				lblFirst.setVisible(true);
				txtFirst.setText(" ");
				txtFirst.setVisible(true);
				lblSecond.setText("Professor");
				lblSecond.setVisible(true);
				txtSecond.setText(" ");	
				txtSecond.setVisible(true);
				lblThird.setText("Department");
				lblThird.setVisible(true);
				txtThird.setText(" ");
				txtThird.setVisible(true);
				btnAdd.setVisible(true);
			}
		});
		btnAddCourseInfo.setBounds(12, 37, 138, 29);
		frame.getContentPane().add(btnAddCourseInfo);
		btnAddCourseInfo.setVisible(false);

		//displays view course panel
		JButton btnViewCourse = new JButton("View Course");
		btnViewCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCancel.setVisible(true);
				btnUpdate.setVisible(false);
				btnEditCourse.setVisible(true);
				btnAdd.setVisible(false);
				lblFirst.setVisible(false);
				lblSecond.setVisible(false);
				txtFirst.setVisible(false);
				txtSecond.setVisible(false);
				btnAdd.setVisible(false);
				txtId.setVisible(false);
				lblId.setVisible(false);
				txtThird.setVisible(false);
				lblThird.setVisible(false);
				comboBox_1.removeAllItems();
				comboBox_1.setVisible(true);
				for(int i = 0; i < courseList.size(); i++){
					comboBox_1.addItem(courseList.get(i));
				}
			}
		});
		btnViewCourse.setBounds(162, 37, 117, 29);
		frame.getContentPane().add(btnViewCourse);
		btnViewCourse.setVisible(false);

		//displays edit Course panel
		btnEditCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCancel.setVisible(true);
				comboBox_1.setVisible(false);
				Courses x=(Courses) comboBox_1.getSelectedItem();
				lblId.setText("Course Id");
				lblId.setVisible(true);
				txtId.setText(x.getId());
				txtId.setEditable(false);
				txtId.setVisible(true);
				lblFirst.setText("Course Name");
				lblFirst.setVisible(true);
				txtFirst.setText(x.getName());
				txtFirst.setVisible(true);
				lblSecond.setText("Professor");
				lblSecond.setVisible(true);
				txtSecond.setText(x.getProfessor());	
				txtSecond.setVisible(true);
				lblThird.setText("Department");
				lblThird.setVisible(true);
				txtThird.setText(x.getDepartment());
				txtThird.setVisible(true);
				btnAdd.setVisible(false);
				btnUpdate.setVisible(true);
				//editCourses();
			}
		});
		btnEditCourse.setBounds(324, 37, 117, 29);
		frame.getContentPane().add(btnEditCourse);
		btnEditCourse.setVisible(false);
		
		// ComboBox created when menu options for user to choose. Depending on
		// selection, certain buttons will be
		// visible or certain methods will be called
		
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Enter Student Info", "Enter Course Information", "Enter Enrollment Information", "Grade Management", "Reports"}));
		comboBox.setBounds(6, 6, 258, 35);
		frame.getContentPane().add(comboBox);
		
		
	
		//removes all panel buttons
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scroll.setVisible(false);
				lblStudentEnroll.setVisible(false);
				cbo2.setVisible(false);
				cbo3.setVisible(false);
				cbo4.setVisible(false);
				cbo5.setVisible(false);
				btnUpdate.setVisible(false);
				btnEditCourse.setVisible(false);
				btnEditStudent.setVisible(false);
				btnAdd.setVisible(false);
				lblFirst.setVisible(false);
				lblSecond.setVisible(false);
				txtFirst.setVisible(false);
				txtSecond.setVisible(false);
				btnAdd.setVisible(false);
				txtId.setVisible(false);
				lblId.setVisible(false);
				txtThird.setVisible(false);
				lblThird.setVisible(false);
				comboBox_1.setVisible(false);
				btnCancel.setVisible(false);
			}
		});
		
		
		
		//Displays buttons or prompts user based on combo box selection
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				@SuppressWarnings("rawtypes")
				JComboBox comboBox = (JComboBox) event.getSource();
				Object selected = comboBox.getSelectedItem();
				if (selected.toString().equals("Enter Student Info")) {
					btnCancel.setVisible(false);
					lblStudentEnroll.setVisible(false);
					cbo2.setVisible(false);
					cbo3.setVisible(false);
					cbo4.setVisible(false);
					cbo5.setVisible(false);
					btnUpdate.setText("Update");
					btnUpdate.setVisible(false);
					btnEditCourse.setVisible(false);
					btnAdd.setVisible(false);
					lblFirst.setVisible(false);
					lblSecond.setVisible(false);
					txtFirst.setVisible(false);
					txtSecond.setVisible(false);
					btnAdd.setVisible(false);
					txtId.setVisible(false);
					lblId.setVisible(false);
					txtThird.setVisible(false);
					lblThird.setVisible(false);
					comboBox_1.setVisible(false);
					scroll.setVisible(false);
					btnAddCourseInfo.setVisible(false);
					btnViewCourse.setVisible(false);
					btnEditCourse.setVisible(false);
					btnAddStudent.setVisible(true);
					btnViewStudent.setVisible(true);
				
				} else if (selected.toString().equals("Enter Course Information")) {
					btnCancel.setVisible(false);
					lblStudentEnroll.setVisible(false);
					cbo2.setVisible(false);
					cbo3.setVisible(false);
					cbo4.setVisible(false);
					btnUpdate.setText("Update");
					btnUpdate.setVisible(false);
					btnEditCourse.setVisible(false);
					btnAdd.setVisible(false);
					lblFirst.setVisible(false);
					lblSecond.setVisible(false);
					txtFirst.setVisible(false);
					txtSecond.setVisible(false);
					txtId.setVisible(false);
					lblId.setVisible(false);
					txtThird.setVisible(false);
					lblThird.setVisible(false);
					comboBox_1.setVisible(false);
					btnAdd.setVisible(false);
					btnAddCourseInfo.setVisible(true);
					btnViewCourse.setVisible(true);
					btnAddStudent.setVisible(false);
					btnViewStudent.setVisible(false);
					btnEditStudent.setVisible(false);
					cbo5.setVisible(false);
					scroll.setVisible(false);
				} else if (selected.toString().equals("Enter Enrollment Information")) {
					btnCancel.setVisible(false);
					btnCancel.setVisible(true);
					btnUpdate.setVisible(true);
					btnUpdate.setText("Enroll");
					lblStudentEnroll.setVisible(true);
					scroll.setVisible(false);
					comboBox_1.removeAllItems();
					comboBox_1.setVisible(true);
					for(int i = 0; i < studentList.size(); i++){
						comboBox_1.addItem(studentList.get(i));
					}	
					lblId.setText("Select Course");
					lblId.setVisible(true);
					cbo2.removeAllItems();
					cbo2.setVisible(true);
					for(int i = 0; i < courseList.size(); i++){
						cbo2.addItem(courseList.get(i));
					}	
					lblFirst.setText("Select Semester");
					lblFirst.setVisible(true);
					cbo3.removeAllItems();
					cbo3.setVisible(true);
					cbo3.addItem("Fall");
					cbo3.addItem("Winter");
					cbo3.addItem("Spring");
					cbo3.addItem("Summer");
					lblSecond.setText("Select Year");
					lblSecond.setVisible(true);
					cbo4.removeAllItems();
					cbo4.setVisible(true);
					cbo4.addItem("2016");
					cbo4.addItem("2017");
					cbo4.addItem("2018");
					cbo4.addItem("2019");
					cbo5.setVisible(false);
					btnEditCourse.setVisible(false);
					btnAdd.setVisible(false);
					txtFirst.setVisible(false);
					txtSecond.setVisible(false);
					btnAdd.setVisible(false);
					txtId.setVisible(false);
					txtThird.setVisible(false);
					lblThird.setVisible(false);
					btnAddCourseInfo.setVisible(false);
					btnAddStudent.setVisible(false);
					btnViewCourse.setVisible(false);
					btnEditCourse.setVisible(false);
					btnViewStudent.setVisible(false);
					btnEditStudent.setVisible(false);
				} else if (selected.toString().equals("Grade Management")) {
					btnCancel.setVisible(false);
					scroll.setVisible(false);
					btnCancel.setVisible(true);
					btnUpdate.setVisible(true);
					btnUpdate.setText("Add Grade");
					lblStudentEnroll.setVisible(true);
					lblStudentEnroll.setText("Select Student For Grading");
					comboBox_1.removeAllItems();
					comboBox_1.setVisible(true);
					for(int i = 0; i < studentList.size(); i++){
						comboBox_1.addItem(studentList.get(i));
					}	
					lblId.setText("Select Course");
					lblId.setVisible(true);
					cbo2.removeAllItems();
					cbo2.setVisible(true);
					for(int i = 0; i < courseList.size(); i++){
						cbo2.addItem(courseList.get(i));
					}
					lblFirst.setText("Select Semester");
					lblFirst.setVisible(true);
					cbo3.removeAllItems();
					cbo3.setVisible(true);
					cbo3.addItem("Fall");
					cbo3.addItem("Winter");
					cbo3.addItem("Spring");
					cbo3.addItem("Summer");
					lblSecond.setText("Select Year");
					lblSecond.setVisible(true);
					cbo4.removeAllItems();
					cbo4.setVisible(true);
					cbo4.addItem("2016");
					cbo4.addItem("2017");
					cbo4.addItem("2018");
					cbo4.addItem("2019");
					lblThird.setText("Select Grade");
					lblThird.setVisible(true);
					cbo5.removeAllItems();
					cbo5.setVisible(true);
					cbo5.addItem("A");
					cbo5.addItem("B");
					cbo5.addItem("C");
					cbo5.addItem("D");
					cbo5.addItem("F");
		//			enterGrades();
					btnEditCourse.setVisible(false);
					btnAdd.setVisible(false);
					txtFirst.setVisible(false);
					txtSecond.setVisible(false);
					btnAdd.setVisible(false);
					txtId.setVisible(false);
					txtThird.setVisible(false);
					lblThird.setVisible(false);
					btnAddCourseInfo.setVisible(false);
					btnViewCourse.setVisible(false);
					btnEditCourse.setVisible(false);
					btnAddStudent.setVisible(false);
					btnViewStudent.setVisible(false);
					btnEditStudent.setVisible(false);
				} else if (selected.toString().equals("Reports")) {
					btnCancel.setVisible(false);
					scroll.setVisible(false);
					btnCancel.setVisible(true);
					lblStudentEnroll.setVisible(true);
					cbo2.setVisible(true);
					cbo3.setVisible(false);
					cbo4.setVisible(false);
					cbo5.setVisible(false);
					btnUpdate.setVisible(true);
					btnEditCourse.setVisible(false);
					btnEditStudent.setVisible(false);
					btnAdd.setVisible(false);
					lblFirst.setVisible(false);
					lblSecond.setVisible(false);
					txtFirst.setVisible(false);
					txtSecond.setVisible(false);
					btnAdd.setVisible(false);
					txtId.setVisible(false);
					lblId.setVisible(true);
					txtThird.setVisible(false);
					lblThird.setVisible(false);
					comboBox_1.setVisible(true);
	
					btnUpdate.setText("Generate Report");
					lblStudentEnroll.setVisible(true);
					lblStudentEnroll.setText("Select Course");
					comboBox_1.removeAllItems();
					comboBox_1.setVisible(true);
					for(int i = 0; i < courseList.size(); i++){
						comboBox_1.addItem(courseList.get(i));
					}
					lblId.setText("Select Year");
					lblId.setVisible(true);
					cbo2.removeAllItems();
					cbo2.setVisible(true);
					cbo2.addItem("2016");
					cbo2.addItem("2017");
					cbo2.addItem("2018");
					cbo2.addItem("2019");
					btnAddCourseInfo.setVisible(false);
					btnViewCourse.setVisible(false);
					btnEditCourse.setVisible(false);
					btnAddStudent.setVisible(false);
					btnViewStudent.setVisible(false);
					btnEditStudent.setVisible(false);
				} 
			}
		});
	}

}


//Course class
class Courses implements Serializable, Comparable<Courses>{
	String name;
	String id;
	String professor;
	String department;
	
	//create course
	Courses( String id, String nm, String professor, String department)
	{
		this.name =nm;
		this.id = id;
		this.department = department;
		this.professor = professor;
	}
	//gets professor
	public String getProfessor() {
		return professor;
	}
	//sets professor
	public void setProfessor(String professor) {
		this.professor = professor;
	}
	//gets department
	public String getDepartment() {
		return department;
	}
	//sets department
	public void setDepartment(String department) {
		this.department = department;
	}
	//Creates class setting id and name	
	
// returns id	
	public String getId() {

		return id;
	}
	
// sets student id	
	void setCourseId(String courseId){
    	this.id = courseId;
    }
// gets course name
	public String getName() {

		return name;
	}
// to string builder
	public String toString() {
		return "Id: " + this.id + " Course: " + this.name ;
	}
// compares id
	@Override
	public int compareTo(Courses o) {
		return id.compareTo(o.id);
	}

}



//student class
class Student implements Serializable, Comparable<Student> {
	String firstName;
	String lastName;
	String birthday;
	String id;

//Creates student and sets id and name
	Student(String id, String firstNm, String lastNm, String birthday ) {
		this.firstName = firstNm;
		this.lastName = lastNm;
		this.birthday=birthday;
		this.id = id;
	}
	//set last name
	void setLastName(String lastName){
		this.lastName = lastName;
	}
	//get last name
	public String getLastName() {
		return lastName;
	}
	//set birthday
	void setBirthday(String bday){
		this.birthday=bday;
	}
	//get birthday
	public String getBirthday(){
		return birthday;
	}
//returns id
	public String getId() {
		return id;
	}
//sets id
	void setStudentId(String studentId){
    	this.id = studentId;
    }
//sets name
	public String getName() {
		return firstName;
	}
//to string method
	public String toString() {
		return "Id: " + this.id + " Student: " + this.firstName + " "+this.lastName ;
	}

//compares id's of other students
	@Override
	public int compareTo(Student o) {
		return id.compareTo(o.id);
	}

}


//enrollment class
class EnrollmentInfo implements Serializable, Comparable<EnrollmentInfo>{
	
	  
    private String semester;
    private String year;
    private String grade;
    private Student student;
    private Courses course;
    

    //create enrollment entry
    public EnrollmentInfo (Student student, Courses course, String semester, String year) {
        this.student=student;
        this.course=course;
        this.semester=semester;
        this.year=year;
    }
    
   
    
    //set semester
    void setSemester(String semester){
    	this.semester = semester;
    }
    //get semester
    String getSemester(){
        return semester;
    }
    
    //set year
    void setYear (String year) {
        this.year   = year;
    }
    //get year
   String getYear(){
        return year;
    }
   
   //get student
   public Student getStudent() {
	return student;
}

//set student
public void setStudent(Student student) {
	this.student = student;
}

//get courses
public Courses getCourse() {
	return course;
}


//set courses
public void setCourse(Courses course) {
	this.course = course;
}

//get grade
public String getGrade() {
	return grade;
}

//set grade
void setGrade (String grade) {
        this.grade   = grade;
    }
 
 //to string method
    public String toString() {
    	return "ID: " +this.student.getId() +"  Name: " +this.student.getName() +" "+ this.student.getLastName()+"\n" + "  Course: "+ this.course.getName() +  "   Semester: " +this.semester + "   Year: " +this.year + "         Grade: " +this.grade+"\n";
    	}

	
    @Override
	public int compareTo(EnrollmentInfo o) {
		return student.getId().compareTo(o.student.getId());
	}

}


//Linked list class
class MyGenericList   <T extends Comparable<T>> implements Serializable
{
	//Creates node class within generic list
	private  class Node<T extends Comparable<T>>implements Serializable
	 {
	 	T value;
	 	Node<T>  next;
	 	
	 	//Creates node based on position and element
	 	Node(T val, Node n){
	 		value=val;
	 		next=n;
	 	}
	 	
	 	//Creates node
	 	Node(T val){
	 		this(val, null);
	 	}
//Compare node method
		public int compareTo(Node<T> node) {
	        return value.compareTo(node.value);
	    }
	 	
	 }	 
	
	//Creates node and sets first & last to null
	//and count to 0
	private Node first = null;
    private Node last = null;
    int count=0;
     
    public MyGenericList(){
    	first=null;
    	last=null;
    }
   //Sort method using insertions sort
    public void sort() {
    	Node<T> current = first;
    	Node<T> insertionPoint=current;
       current=current.next;
       while(current!=null){
    	   insertionPoint=first;
    	   while (insertionPoint!=current){
    		   if(0<insertionPoint.value.compareTo((T) current.value)){
    			   T temp=current.value;
    			   current.value=insertionPoint.value;
    			   insertionPoint.value=temp;
    		   }
    		   else{
    			   insertionPoint=insertionPoint.next;
    		   }
    	   }
    	   current=current.next;
       }
        
    }
 //Check is list is empty   
    public boolean isEmpty(){
    	return first==null;
    }
    //Add method
    public void  add(T element)
     {
      	 //If empty, set node as first and last
    	if (isEmpty()){
    		first=new Node(element);
    		last=first;
    	}
    	else{
    		//Add to end of existing list
    		last.next=new Node(element);
    		last=last.next;
    	}
    	count++;
      
     }
    //Gets value of based on position
    public T get(int pos)
    {
    	 Node<T> Nodeptr = first;
    	 int hopcount=0;
    	 while (hopcount < count && hopcount<pos)
    	 {   if(Nodeptr!=null)
    	 	 {
    		    Nodeptr = Nodeptr.next;
    	 	 }
    		 hopcount++;
    	 }
    	return  Nodeptr.value;
    }
    //Gives size of linked list
    public int size()
    {
    	int size =0;
    	Node p =first;
    	while(p !=null)
    	{
    		//there is an element at P
    		size++;
    		p=p.next;
    	}
        return size;
    }

   
	
	//Removes node
	public void remove(int index){
		if (index<0 || index>=size()){
			String message=String.valueOf(index);
			throw new IndexOutOfBoundsException(message);
		}
		if(index==0)
		{
			//removal of first item in the list
			first=first.next;
			if(first==null)
				last=null;
		}
		else{
			//To remove an element other than the first,
			//Find the predecessor of the element to be removed
			Node pred=first;
			
			//Move pred forward index-1 times
			for (int k = 1; k <=index-1; k++)
				pred=pred.next;
			//route link around the node to be removed
			pred.next=pred.next.next;
			
			//Check is pred is now last
			if (pred.next==null)
				last=pred;
		}
		count--;
	}
	
	//Inputing a new node at specific position
	public void add(int index, T element){
		if (index<0 || index>size()){
			String message = String.valueOf(index);
			throw new IndexOutOfBoundsException(message);
		}
		
		//Index is at least 0
		if (index==0)
		{
			//New element goes at beginning
			
			first =new Node(element, first);
			if(last==null)
				last=first;
			return;
		}
		
		//Set a preference pred to point to the node
		//that will be the predecessor of the new node
		Node pred=first;
		for (int k=1; k <=index-1; k++){
			pred=pred.next;
		}
		
		//Splice in a node containing the new element
		pred.next =new Node(element, pred.next);
		
		//Is there a new last element?
		if (pred.next.next==null)
			last=pred.next;
		count++;
	}
//To string method
	public String toString()
	{
		StringBuilder strBuilder = new StringBuilder();
		//Use p to walk down the linked list
		Node p=first;
		
		while (p !=null)
		{
			strBuilder.append(p.value + "\n");
			p=p.next;
		}
		return strBuilder.toString();
	}
	
	
		
}
	
	   




