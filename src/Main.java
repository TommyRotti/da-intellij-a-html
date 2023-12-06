import java.io.*;

public class Main {
    public static void main(String[] args) {

        File f = new File("Prova.txt");
        File q = new File("Scontrino.html");
        String[] t = null;
        double g, j;
        int h;
        double tot = 0.0, totTot = 0.0;
        if(f.exists()){
            try{
                BufferedReader br = new BufferedReader((new FileReader(f)));
                BufferedWriter bw = new BufferedWriter((new FileWriter(q)));

                bw.write("<head>\n");
                bw.write("<h1>Scontrino </h1>\n");
                bw.write("\t<table border='3'>\n");

                bw.write("\t\t<th></th>\n");
                bw.write("\t\t<th>Costo Singolo</th>\n");
                bw.write("\t\t<th>Quantità</th>\n");
                bw.write("\t\t<th>Sconto</th>\n");
                bw.write("\t\t<th>Totale</th>\n\n");


                String s = "";
                while((s = br.readLine()) != null){
                    t = s.split(" ");
                    bw.write("\t\t<tr>\n");
                    bw.write("\t\t\t<td>"+(t[0])+"</td>\n");
                    for(int i=0; i<t.length; i++){
                        if(i==1){
                            g = Double.parseDouble(t[i]);
                            tot += g;
                            bw.write("\t\t\t<td>"+g+"</td>\n");
                        }
                        if(i==2){
                            h = Integer.parseInt(t[i]);
                            tot *= h;
                            bw.write("\t\t\t<td>"+h+"</td>\n");
                        }
                        if(i==3){
                            j = Double.parseDouble(t[i].replace("%", ""));
                            if(j!=0){
                                tot =  tot*(1-(j/100));
                                bw.write("\t\t\t<td>"+j+"%</td>\n");
                                tot = Math.floor(tot * 100.00) / 100.00;
                                bw.write("\t\t\t<td>"+tot+"</td>\n");
                            }else if(j==0){
                                bw.write("\t\t\t<td>NO SCONTO</td>\n");
                                tot = Math.floor(tot * 100.00) / 100.00;
                                bw.write("\t\t\t<td>"+tot+"</td>\n");
                            }
                        }
                    }
                    t[0] = ""+Math.floor(tot * 100.00) / 100.00;
                    System.out.println(t[0]);
                    totTot+=tot;
                    tot = 0;
                    totTot = Math.floor(totTot * 100.00) / 100.00;
                    bw.write("\t\t</tr>\n");
                }
                System.out.println("\nTotale da pagare: "+totTot);
                bw.write("\t\t<tr>\n");
                bw.write("\t\t\t<td><b>Totale da pagare: </b></td>");
                bw.write("<td><td></td><td></td><td> <b>"+totTot+"</b></td>");
                bw.write("\t\t</tr>\n");
                bw.write("</table>");

                br.close();
                bw.close();

            } catch (Exception e) {
                System.out.println("ERRORE!");
            }
        }
    }
}