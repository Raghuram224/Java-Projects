package FourteReverse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class FourteReverse {
    
    int target;
    int[] correctOptions=new int[2];
    int[]options=new int[4];
    char operator;
    public FourteReverse(int target){
        this.target=target;
    }

    public String matchFinder(){      
        Scanner scanner = new Scanner(System.in);
        String answer=" ";

        try {       
                
                System.out.println("Enter your options by comma seprated :");
                String optionsString = scanner.nextLine();
                String[] tempOptions = optionsString.split(",");
                for (int i=0;i< tempOptions.length;i++){
                    options[i]=Integer.parseInt(tempOptions[i]);
                }
                
                resultGetter(options);
            System.out.println("Answer: "+correctOptions[0]+" "+operator+" "+correctOptions[1]+" = "+target);


        } catch (Exception e) {

            e.printStackTrace();
        }
        return answer;
    }
    public void resultGetter(int[] options){
            ArrayList<Integer> temp;
            
            int operatorCheckedCount=4;
            int bruteForceCount=1;
            
            for(int i=0; i<options.length; i++){
                temp = new ArrayList<>();
                
                for(int j=0; j<options.length; j++){
                    if (i == j){
                        continue;
                    }
                    else{
                        temp.add(options[j]);
                    }
                }
                
                System.out.println("temp"+temp);
                
//                if (bruteForceCount==4){
//                    operatorCheckedCount++;
//                }
                
                if (bruteForceCount%5==0){
                    operatorCheckedCount++;
                }
                else if (isMatchFound(temp, operatorCheckedCount)) {
                    break;
                }else {
                    bruteForceCount++;
                }
            }
        
    }

    public boolean isMatchFound(ArrayList<Integer> tempOptions,int operatorCheckedCount){
        boolean isMatchFound=false;
//        System.out.println(tempOptions+"temp");
        switch (operatorCheckedCount) {
            case 1:
                System.out.println("add");
                for(int i=0;i<tempOptions.size();i++){
                    for(int j=0;j<tempOptions.size();j++){
                        System.out.println(tempOptions.get(i)+" "+tempOptions.get(j));
                        if (tempOptions.get(i)+tempOptions.get(j)==this.target && i!=j) {
                            correctOptions[0]= tempOptions.get(i);
                            correctOptions[1]=tempOptions.get(j);
                            isMatchFound=true;
                            operator='+';
                            return  isMatchFound;
                        }
                    }
                }
                break;
            case 2:
                System.out.println("min");
                for(int i=0;i<tempOptions.size();i++){
                    for(int j=0;j<tempOptions.size();j++){
                        System.out.println(tempOptions.get(i)+" "+tempOptions.get(j));
                        if (tempOptions.get(i)-tempOptions.get(j)==this.target && i!=j) {
                            correctOptions[0]= tempOptions.get(i);
                            correctOptions[1]=tempOptions.get(j);
                            isMatchFound=true;
                            operator='-';
                            return  isMatchFound;
                        }
                    }
                }
                break;
            
            case 3:
                System.out.println("mul");
                for(int i=0;i<tempOptions.size();i++){
                    for(int j=0;j<tempOptions.size();j++){
                        
                        if (tempOptions.get(i)*tempOptions.get(j)==this.target && i!=j) {
                            correctOptions[0]= tempOptions.get(i);
                            correctOptions[1]=tempOptions.get(j);
                            isMatchFound=true;
                            operator='*';
                            return  isMatchFound;
                        }
                    }
                }
                break;
            case 4:
                System.out.println("Div");
                for(int i=0;i<tempOptions.size();i++){
                    for(int j=0;j<tempOptions.size();j++){
                        
                        if (tempOptions.get(i)/tempOptions.get(j)==this.target && i!=j) {
                            correctOptions[0]= tempOptions.get(i);
                            correctOptions[1]=tempOptions.get(j);
                            isMatchFound=true;
                            operator='/';
                            return  isMatchFound;
                        }
                    }
                }
                break;
            default:
                break;
        }

        return isMatchFound;
        
    }
   
}
