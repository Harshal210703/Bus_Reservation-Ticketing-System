import java.io.*;
public class BusReservationAndTicketingSystem {

    public static void main(String args[]) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    
    String user,password,yn,search,again,choice;
    int to=0,y=1,z=0,end=0;

	//stores available no of seats [no of destinations]
    int available[] = new int[6];

	//stores no of passengers
	int total_passengers = 0;

	//string('s') array [rows][columns]
	//stores name, destination and in billing 'x' to check if customer has paid or not 
    String ticketS[][] = new String[100][3];

	//double('d') array
	//stores fair price
	//stores total cost in the end
    double ticketD[][] = new double [100][2];

    double pay[] = new double[20];
    double change[] = new double[20];
    
	//four attempts to try after which it will exit the application
    for(int i=1;i<4;){
		System.out.print("Enter Username: ");
		user = in.readLine();
		System.out.print("Enter Password: ");
		password = in.readLine();
    
    	//"available[]" is the SEAT AVAILABLE//
		//store 20 seats for every destination which are from 1 to 5
    	for(int o=1; o<=5; o++){
    		available[o]=20;
  		}
    
    	//if user and password are correct proceed to MAIN MENU//
    	if(user.equals("test") && password.equals("test")){
    	
    		//basically for x = true
			for(int x=1; x==1;){
    			//the MAIN MENU//
    			System.out.println("********************************************");
    			System.out.println("BUS RESERVATION AND TICKETING SYSTEM");
				System.out.println("Origin: JAIPUR ");
    			System.out.println("********************************************");
    			System.out.println("[1] Destination                   ");
    			System.out.println("[2] Passengers                    ");
    			System.out.println("[3] Billing                       ");
    			System.out.println("[4] View                          ");
    			System.out.println("[5] Exit                          ");
    			System.out.println("***************************************");
    			System.out.println("***************************************\n");
    	
				//x = true
    			for(x=1; x==1;){
					System.out.print("ENTER CHOICE: ");
					choice=in.readLine();
					
					//if CHOICE is "1" display the DESTINATIONS//
					if (choice.equals("1")){
						//the DESTINATION DETAILS//
						//display the "Destination", every destination "Fare", and the "Seat" available//

    					System.out.println("***************************************");
    					System.out.println(" DESTINATION   |  FARE  |  SEAT ");
    					System.out.println("***************************************");
						System.out.println("1.)AJMER     	 | Rs. 600 |   "+available[1]); //show the no of available 
    					System.out.println("2.)JODHPUR    	 | Rs. 170 |   "+available[2]); //seats at each index = 20
    					System.out.println("3.)UDAIPUR    	 | Rs. 150 |   "+available[3]); //initially
    					System.out.println("4.)KOTA       	 | Rs. 200 |   "+available[4]);
    					System.out.println("5.)JAISALMER  	 | Rs. 250 |   "+available[5]);
    					System.out.println("***************************************");
						System.out.println("***************************************\n");
    					
						//after execution of choice = '1'; exit the for loop by making x = false
						x=0;
					}
					
					//if CHOICE is "2" proceed to Ticket Booking//
					else if (choice.equals("2")){
						int print=1;
						
						
						
						//display first the Destination Details//
						System.out.println("***************************************");
    					System.out.println(" DESTINATION   |  FARE  |  SEAT ");
    					System.out.println("***************************************");
						System.out.println("1.)AJMER     	 | Rs. 600 |   "+available[1]); 
    					System.out.println("2.)JODHPUR    	 | Rs. 170 |   "+available[2]); 
    					System.out.println("3.)UDAIPUR    	 | Rs. 150 |   "+available[3]); 
    					System.out.println("4.)KOTA       	 | Rs. 200 |   "+available[4]);
    					System.out.println("5.)JAISALMER  	 | Rs. 250 |   "+available[5]);
    					System.out.println("***************************************");
						System.out.println("***************************************\n");
    					
						//if available seats for all destinations = 0
    					if((available[1]==0)&&(available[2]==0)&&(available[3]==0)&&(available[4]==0)&&(available[5]==0)){
    						System.out.println("Sorry, We don't  have available seats for all Destination!");

							//after execution of choice = '2'; exit the for loop by making x = false
    						x=0;
    						
    					}
    					
    					
    					
    					//inputing of Passenger's Name//
    					else{
    					for(x=1; x==1;){
    						System.out.print("\nENTER PASSENGER'S NAME: ");
    						ticketS[z][0] = in.readLine();
							
							//after execution of this statement exit the for loop by making x = false
							x=0;
							
							//if Passenger's Name already used, display error and go back to Inputing//
    						for(int l=0; l<z; l++){
    							if(ticketS[l][0].equalsIgnoreCase(ticketS[z][0])){
    								System.out.println("Sorry, Passenger's name have already used!");
									
									//make x = true again so that initial statement for taking input is executed again
    								x=1;
    							}
    						}
    					}
    					
    					//inputing of Destination//
    					//integers Only [1-5]//
    					for(x=1; x==1;){
    						System.out.print("ENTER DESTINATION [number]: ");

							//converting string input to integer since 'to' is of int type 
    						to = Integer.parseInt(in.readLine());
    						
    						//if Inputed integers are "<1" or ">5", display error and go back to Inputing//
    						if(to<1 || to>5){
    							System.out.println("Invalid Input!");

								//make x = true again so that initial statement for taking input is executed again
    							x=1;
    						}
    						//if available seat is eqaul to "Zero", display error and go back to Inputing//
    						for(int d=1; d<=5; d++){
    							if(to==d){
    								if(available[to]==0){
    									System.out.println("Sorry, We don't have available seat!");

										//make x = true again so that initial statement for taking input is executed again
    									x=1;
    								}

									//after executing set of statements exit the for loop by making x = false
    								x=0;
    							}
    						}
    					}
    					
    					//storing in arrays
    					String dest[] = { " ", "AJMER", "JODHPUR", "UDAIPUR", "KOTA", "JAISALMER"};
    					double fare[] = { 0,600,170,150,200,250};
    		
    					//at row = 1, storing the destination name (in string) as inputed by user in ticketS array 
    					ticketS[z][1] = dest[to];

						//at row = 0, storing the fair price corresponding to the destination in ticketD array
    					ticketD[z][0] = fare[to];
    					
    					//inputing for Number of Passenger's//
    					for(x=1; x==1;){
    					System.out.print("HOW MANY PASSENGERS ARE YOU?: ");
    					total_passengers = Integer.parseInt(in.readLine());
    		
    						//subtract the available seat by the the number inputed//
    						for(int p=1; p<=5; p++){
    							if(to==p){
    								print=1;
									available[to] = available[to]-total_passengers;
    								
    								//if the subtracted available seat is "<0", display error//
    								//add the inputed number to the subtracted seat, to back the original seat//
    								//display the available seat and back to the inputing//
    								if(available[to]<0){
										System.out.print("Sorry, We don't have seat available for " +total_passengers +" person\n");
    									available[to] = available[to]+total_passengers;
    									System.out.print("We only have " +available[to] +" seat available\n");

    									x=1;
    									print=0;
    								}
    								else{
    									x=0;
    								}
    							}
    						}
    		
    					}
    					
    		
    					//print out of passengers details....
    					if(print==1){
    						System.out.println("\n***************************************");
    						System.out.println("**        PASSENGER'S DETAILS        **");
    						System.out.println("***************************************");
    						System.out.println("PASSENGER'S NAME: " + ticketS[z][0]);
    						System.out.println("PASSENGER'S DESTINATION : " + ticketS[z][1]);
    						System.out.println("FARE PRICE: Rs. " + ticketD[z][0]);
    						System.out.println("NO. OF PASSENGERS: " + total_passengers);
    						System.out.println("***************************************");
    						System.out.println("***************************************\n");
    						ticketS[z][2]="0";
							ticketD[z][1]= total_passengers * ticketD[z][0];

							//after execution of choice = '1'; exit the for loop by making x = false
    						x=0;
    					}
    					z++;
    					}
					}
					
					else if (choice.equals("3")){
			          
			            
						for(x=1; x==1;){
							
								System.out.print("ENTER PASSENGER'S NAME: ");
								search = in.readLine();
								
								
								int s=1;
								for(int b=0;b<z;b++){
									if(search.equalsIgnoreCase(ticketS[b][0])){
										System.out.println("***************************************");
	    								System.out.println("**        PASSENGER'S DETAILS        **");
	    								System.out.println("***************************************");
	    								System.out.println("PASSENGER'S NAME: " + ticketS[b][0]);
	    								System.out.println("PASSENGER'S DESTINATION : " + ticketS[b][1]);
	    								System.out.println("FARE PRICE: Rs. " + ticketD[b][0]);
										System.out.println("NO. OF PASSENGERS: " + total_passengers);
		 		   						System.out.println("***************************************");
	    								System.out.println("***************************************");
	    								s=0;
										x=0;
										
										if(ticketS[b][2].equals("x")){
	    									System.out.println("Passenger's Already Paid!");

	    									x=0;
	    								}
	    								else{
	    									ticketS[b][2]="x";
	    									
	    								
	    									for(x=1; x==1;){
	    										System.out.println("\nPASSENGER'S TOTAL FARE: Rs. "+ticketD[b][1]);
	    										System.out.print("ENTER AMOUNT TO PAY: ");
	    										pay[b] = Double.parseDouble(in.readLine());
	    										change[b]=pay[b]-ticketD[b][1];
	    							
	    										if(change[b]<0){
	    											System.out.println("Invalid Input!");
	    											x=1;
	    										}
	    										else{
	    											System.out.println("CHANGE: Rs. "+change[b]);
	    											System.out.println("");

	    											x=0;
	    										}
	    									}
										}
									}
								}
								if (s==1){
									System.out.println("\nPASSENGER'S NAME NOT FOUND!\n");
									for(int q=1; q==1;){
									
									System.out.print("Do you wish to continue with this transaction? [Y/N]: ");
									again=in.readLine();
									
									if(again.equalsIgnoreCase("y")){
										q=0;
									}
									else if (again.equalsIgnoreCase("n")){
										q=0;
										x=0;
										
									}
									else{
										System.out.println("\nInvalid input!\n");
									}
								
						
								}
							}	
						}
			            
					}
					
					else if (choice.equals("4")){
						
						
						for(int sx=1; sx<=3;){
 						System.out.print("SEARCH PASSENGER'S NAME: ");
    					search = in.readLine();
    		    
    		 		   	int s=1;
							for(x=0; x<=z; x++){
								if(search.equalsIgnoreCase(ticketS[x][0])){
									System.out.println("***************************************");
    								System.out.println("**        PASSENGER'S DETAILS        **");
    								System.out.println("***************************************");
    								System.out.println("PASSENGER'S NAME: " + ticketS[x][0]);
    								System.out.println("PASSENGER'S DESTINATION : " + ticketS[x][1]);
    								System.out.println("FARE PRICE: Rs. " + ticketD[x][0]);
									System.out.println("NO. OF PASSENGERS: " + total_passengers);
    								System.out.println("TOTAL FARE PRICE: Rs. " + ticketD[x][1]);
    								if(ticketS[x][2].equals("x")){
    									System.out.println("PAY: Rs. " +pay[x]);
    									System.out.println("CHANGE: Rs. " +change[x]);
    									System.out.println("STATUS: PAID");
    								}
    								else{
    									System.out.println("STATUS: NOT PAID");
    								}
    								System.out.println("***************************************");
    								System.out.println("***************************************");
    								s=0;
								    sx=4;
								}
							}	
						
							
							if (s==1){
								System.out.println("Passenger's Name not found!");
								sx++;
							}
							
				    	}
					}		
					
					else if(choice.equals("5")){
						end=1;

						//after execution of choice = '5'; exit the for loop by making x = false
						x=0;
						System.out.println("Thank You!");
					}
				
					else{
						System.out.println("Invalid Input!");

						x=1;
					}
    			}
    	
    			for(y=1; y==1;){
    				if(end==1){
    					break;
    				}
    				System.out.print("Do you want another transaction? [Y/N]: ");
   				 	yn = in.readLine();
    	
    				if (yn.equalsIgnoreCase("y")){
    					x=1;
    					y=0;
    				}
    				else if (yn.equalsIgnoreCase("n")){
    					System.out.println("\nThank You!!!");
    					break;
    				}
    				else{
    					System.out.println("Invalid Input!!!");
    					y=1;
    				}
    			}
    		}
    		i=4;
    	}
    	else{
    		System.out.println("\nInvalid user or password!\n");
    		i++;
		}
	
    }
    
    }
    
    
}