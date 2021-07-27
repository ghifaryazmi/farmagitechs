package faramagitech;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.FileReader;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.File;

public class Primary {
	
	static InputStreamReader inputStreamReader = new InputStreamReader(System.in);
    static BufferedReader input = new BufferedReader(inputStreamReader);

	public static void main(String[] args) {
		menu();
	}
	
	static void menu() {
        System.out.println("Kelola Data");
        System.out.println("_________________");
        System.out.println("1. Data Restaurant");
        System.out.println("2. Data Menu");
        System.out.println("3. Data City");
        System.out.println("0. Keluar");
        System.out.println("");
        System.out.print("PILIHAN> ");

        try {
            int pilihan = Integer.parseInt(input.readLine());

            switch (pilihan) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    crudMenu(pilihan);
                    break;
                case 2:
                    crudMenu(pilihan);
                    break;
                case 3:
                    System.out.println("3");
                    break;
                default:
                    System.out.println("Pilihan salah!");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
	static void crudMenu(int id) {
		switch (id) {
			case 1:
				System.out.println("Data Restaurant");
				break;
			case 2:
				System.out.println("Data Menu");
				break;
			case 3:
				System.out.println("Data City");
				break;
			default:
				System.out.println("Pilihan Salah");
		}
        System.out.println("1. Tambah Data");
        System.out.println("2. Tampilkan Data");
        System.out.println("3. Edit Data");
        System.out.println("4. Hapus Data");
        System.out.println("");
        System.out.print("PILIHAN> ");
        
        try {
            int pilihan = Integer.parseInt(input.readLine());

            switch (pilihan) {
			case 1:
				insert(id);
				break;
			case 2:
				showData(id);
				break;
			case 3:
				System.out.println("Data City");
				break;
			case 4:
				deleteData(id);
				break;
			default:
				System.out.println("Pilihan Salah");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	static void insert(int id) {
		try {
			String jenis;
			
			if(id==1) {
				jenis = "Restaurant";
			} else if (id==2) {
				jenis = "Menu";
			} else {
				jenis = "City";
			}
			BufferedWriter bw = new BufferedWriter( new FileWriter("data"+jenis+".txt",true) );
    		Scanner strInput = new Scanner(System.in);
    		
			String ID, name, addr, menu, numberRestaurant;
			
			if(id==1) {
				System.out.print("input id: ");
				ID = strInput.nextLine();
				System.out.print("input nama restaurant: ");
				name = strInput.nextLine();
				System.out.print("input alamat: ");
				addr = strInput.nextLine();
				System.out.print("input menu: ");
				menu = strInput.nextLine();
				bw.write(ID+","+name+","+addr+","+menu);
			} else if (id==2) {
				System.out.print("input id: ");
				ID = strInput.nextLine();
				System.out.print("input menu: ");
				menu = strInput.nextLine();
				bw.write(ID+","+menu);
			} else {
				System.out.print("input id: ");
				ID = strInput.nextLine();
				System.out.print("input nama restaurant: ");
				name = strInput.nextLine();
				System.out.print("input jumlah restaurant: ");
				numberRestaurant = strInput.nextLine();
				bw.write(ID+","+name+","+numberRestaurant);
			}
			    		
			   		
    		bw.flush();
    		bw.newLine();
    		bw.close();		
			System.out.println("Data sukses disimpan");
		}catch(Exception e){
			System.out.println("Data gagal disimpan");
		}
		
	}
	
	static void showData(int id) {
		try {
			String jenis;
			
			if(id==1) {
				jenis = "Restaurant";
			} else if (id==2) {
				jenis = "Menu";
			} else {
				jenis = "City";
			}
			BufferedReader br = new BufferedReader( new FileReader("data"+jenis+".txt") );
			
	    	String record;
	    	if(id==1) {
	    		System.out.println(" ------------------------------------------------------------- ");
		    	System.out.println("|	ID		Name 				Address			Menu 		  |");
		    	System.out.println(" ------------------------------------------------------------- ");
		    		
		    	while( ( record = br.readLine() ) != null ) {
		    			
		    		StringTokenizer st = new StringTokenizer(record,",");
		    			
		    		System.out.println("|	"+st.nextToken()+"	"+st.nextToken()+" 		"+st.nextToken()+"			"+st.nextToken()+"      |");
			
		    	}
		    		
		    	System.out.println("|	                                            	          |");
		    	System.out.println(" ------------------------------------------------------------- ");
	    	} else if(id==2) {
	    		System.out.println(" ------------------------------------------------------------- ");
		    	System.out.println("|	ID		Menu 		  |");
		    	System.out.println(" ------------------------------------------------------------- ");
		    		
		    	while( ( record = br.readLine() ) != null ) {
		    			
		    		StringTokenizer st = new StringTokenizer(record,",");
		    			
		    		System.out.println("|	"+st.nextToken()+"	"+st.nextToken()+"      |");
			
		    	}
		    		
		    	System.out.println("|	                                            	          |");
		    	System.out.println(" ------------------------------------------------------------- ");
	    	} else {
	    		System.out.println(" ------------------------------------------------------------- ");
		    	System.out.println("|	ID		Name 				NumberRestaurant 		  |");
		    	System.out.println(" ------------------------------------------------------------- ");
		    		
		    	while( ( record = br.readLine() ) != null ) {
		    			
		    		StringTokenizer st = new StringTokenizer(record,",");
		    			
		    		System.out.println("|	"+st.nextToken()+"	"+st.nextToken()+"			"+st.nextToken()+"      |");
			
		    	}
		    		
		    	System.out.println("|	                                            	          |");
		    	System.out.println(" ------------------------------------------------------------- ");
	    	}
	    	
	    	br.close();
		}catch(Exception e) {
			System.out.println("Data gagal tampil");
		}
		
	}
	
	static void deleteData(int id) {
		try {
			Scanner strInput =  new Scanner(System.in);
    		String ID, record, jenis;
			
			if(id==1) {
				jenis = "Restaurant";
			} else if (id==2) {
				jenis = "Menu";
			} else {
				jenis = "City";
			}
    		
    		
    		File tempFile = new File("data"+jenis+"temp.txt");
    		File file = new File("data"+jenis+".txt");
    		
    		
    		BufferedReader br = new BufferedReader( new FileReader( file ) );
    		BufferedWriter bw = new BufferedWriter( new FileWriter( tempFile ) );
    		
    		System.out.println("Masukan ID "+jenis+": ");
    		ID =  strInput.nextLine();
    		
    		
    		while( ( record = br.readLine() ) != null ) {
    			
    			
    			if( record.contains(ID) ) 
    				continue;
   
    			bw.write(record);
    			bw.flush();
    			bw.newLine();
 
    		}
    		
    		br.close();
    		bw.close();
    		
    		file.delete();
    		
    		tempFile.renameTo(file);
    		System.out.println("Data sukses dihapus");
		}catch(Exception e){
			System.out.println("Data gagal dihapus");
		}
	}
	
	static void editData(int id) {
		try {
			String jenis, ID, name, addr, menu, numberRestaurant, record;
			
			if(id==1) {
				jenis = "Restaurant";
			} else if (id==2) {
				jenis = "Menu";
			} else {
				jenis = "City";
			}
			System.out.println("Update Data"+jenis);
			
			File file = new File("data"+jenis+".txt");
    		File tempFile = new File("data"+jenis+"temp.txt");
    		
    		BufferedReader reader = new BufferedReader( new FileReader(file) );
    		BufferedWriter writer = new BufferedWriter( new FileWriter(tempFile) );
    		    		
    		Scanner strInput = new Scanner(System.in);
    		
    		System.out.println("Enter the Employee ID: ");
	    		ID = strInput.nextLine();	    		
	    		System.out.println(" ------------------------------------------------------------- ");
	    		System.out.println("|	ID		Name 				Age			Address 		  |");
	    		System.out.println(" ------------------------------------------------------------- ");
	    		
	    		while( ( record = reader.readLine() ) != null ) {
	    			
	    			StringTokenizer st = new StringTokenizer(record,",");
	    			if( record.contains(ID) ) {
	    				System.out.println("|	"+st.nextToken()+"	"+st.nextToken()+" 		"+st.nextToken()+"			"+st.nextToken()+"      |");
	    			}
	    			
	    		}	    		
	    		System.out.println("|	                                            	          |");
	    		System.out.println(" ------------------------------------------------------------- ");
	    		
	    	reader.close();
    		
		}catch(Exception e) {
			System.out.println("Data gagal dihapus");
		}
	}

}
