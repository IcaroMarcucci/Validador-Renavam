import java.util.Scanner;

public class ValidadorRenavam{
    public static void main(String[] args) {
        
        boolean validacao = false;
        Scanner entrada = new Scanner(System.in);

        while (validacao != true) {
            
            System.out.println("Digite o Renavam a ser validado (somente números):");
            String renavam = entrada.nextLine();

            if (renavam.matches("^([0-9]{11})$")) {
                validar(renavam);
                validacao = true;
            } else if(renavam.matches("^([0-9]{9})$")) {
                renavam = "00" + renavam;
                validar(renavam);
                validacao = true;
            } else {
                System.out.println("Renavam inválido!");
            }
        }
        entrada.close();
    }

    static void validar(String str) {
        int soma = 0;
        String strFormatado = str.substring(0, 10); //Retira o ultimo digito
        strFormatado = new StringBuilder(strFormatado).reverse().toString(); //Inverte a string
        for (int i = 0; i < 8; i++){
            Integer numero = Integer.parseInt(strFormatado.substring(i, i + 1)); //Guarda cada digito dentro do array
            int mult = i + 2;
            soma += numero * mult; //Multiplica cada item do array pelo fator multiplicativo fixo
        }

        soma += Character.getNumericValue(strFormatado.charAt(8))*2; //Multiplica o penultimo numero
        soma += Character.getNumericValue(strFormatado.charAt(8))*3; //Multiplica o ultimo numero

        int digito = soma % 11;
        digito = 11 - digito;

        int ultimoDigito = (digito >= 10 ? 0 : digito);

        int UltimoDigitoReal = Integer.valueOf(str.substring(str.length()-1, str.length()));

        if (UltimoDigitoReal == ultimoDigito){
            System.out.println("Renavam Válido!");
        } else {
            System.out.println("Renavam Inválido!");
        }
        
    }
    
}