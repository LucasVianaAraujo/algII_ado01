
import javax.swing.JOptionPane;

public class BubbleSort {

    public static void main(String[] args) {
        String[] nomes = new String[5];
        int[] senhas = new int[5];
        String[] arrayDeNomes = nomes;
        int[] arrayDeSenhas = senhas;
        int escolha;
        boolean loop = true;

        while (loop) {
            escolha = Integer.parseInt(JOptionPane.showInputDialog(
                    "Opções:\n1 - Informar Dados\n2 - Ler Todos os Dados\n3 - Buscar Nome\n4 - Buscar Senha\n5 - Classificar Nomes\n6 - Classificar Senhas\n7 - Sair"));
            switch (escolha) {
                case 1:
                    InformarDados(nomes, senhas);
                    break;
                case 2:
                    LerDados(arrayDeNomes, arrayDeSenhas);
                    break;
                case 3:
                    BuscarNome(arrayDeNomes);
                    break;
                case 4:
                    BuscarSenha(arrayDeSenhas);
                    break;
                case 5:
                    arrayDeNomes = ReorganizarNomes(arrayDeNomes); // tratar
                    break;
                case 6:
                    arrayDeSenhas = ReorganizarSenhas(arrayDeSenhas); // tratar
                    break;
                case 7:
                    loop = false;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção Inválida...\n");
            }
        }
    }

    public static void InformarDados(String[] arrayNomes, int[] arraySenhas) {
        int escolha = Integer.parseInt(JOptionPane.showInputDialog("1 - Informar Nome\n2 - Informar Senha"));
        switch (escolha) {
            case 1:
                String nome = JOptionPane.showInputDialog("Informe o nome:");
                for (int i = 0; i < arrayNomes.length; i++) {
                    if (arrayNomes[i] == null) {
                        arrayNomes[i] = nome;
                        JOptionPane.showMessageDialog(null, "Nome cadastrado!");
                        return;
                    }
                }
                JOptionPane.showMessageDialog(null, "Lista de nomes está cheia!");
                return;
            case 2:
                int senha = Integer.parseInt(JOptionPane.showInputDialog("Informe a senha:"));
                for (int i = 0; i < arraySenhas.length; i++) {
                    if (arraySenhas[i] == 0) {
                        arraySenhas[i] = senha;
                        JOptionPane.showMessageDialog(null, "Senha cadastrada!");
                        return;
                    }
                }
                JOptionPane.showMessageDialog(null, "Lista de senhas está cheia!");
                return;
            default:
                JOptionPane.showMessageDialog(null, "Opção inválida!");
                return;
        }
    }

    public static void LerDados(String[] arrayNomes, int[] arraySenhas) {

        String dados = "";

        for (int i = 0; i < arrayNomes.length; i++) {

            if (arrayNomes[i] != null && arraySenhas[i] != 0) {

                dados += "Nome: " + arrayNomes[i] + " | Senha: " + arraySenhas[i] + "\n";
            }
        }

        if (dados.length() > 0) {
            JOptionPane.showMessageDialog(null, dados);
        } else {
            JOptionPane.showMessageDialog(null, "Nenhum dado encontrado!");
        }
    }

    public static void BuscarNome(String[] arrayDeNomes) {

        String buscarNome = JOptionPane.showInputDialog(null, "Buscar nome:");

        boolean encontrado = false;

        for (int i = 0; i < arrayDeNomes.length; i++) {

            if (arrayDeNomes[i] != null && arrayDeNomes[i].equalsIgnoreCase(buscarNome)) {
                JOptionPane.showMessageDialog(null,
                        "O nome:" + buscarNome + "foi encontrando na posição: " + "[" + i + "]");

                encontrado = true;
                break;

            }
        }

        if (!encontrado) {
            JOptionPane.showMessageDialog(null, "O nome " + buscarNome + "não foi encontrado");
        }
    }

    public static void BuscarSenha(int[] arrayDeSenhas) {

        int buscarSenha = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite a senha:"));

        boolean senhaEncontrada = false;

        for (int i = 0; i < arrayDeSenhas.length; i++) {

            if (arrayDeSenhas[i] == buscarSenha) {
                JOptionPane.showMessageDialog(null,
                        "A senha " + buscarSenha + "foi encontrada na posição" + "[" + i + "]");

                senhaEncontrada = true;
                break;
            }
        }

        if (!senhaEncontrada) {
            JOptionPane.showMessageDialog(null, "A senha " + buscarSenha + "não foi encontrada");
        }
    }

    public static String[] ReorganizarNomes(String[] arrayDeNomes) {
        String aux = "";
        String nome = null;
        for (int i = 0; i < arrayDeNomes.length; i++) {
            for (int j = 0; j < arrayDeNomes.length - 1; j++) {
                if (arrayDeNomes[j] != null
                        && arrayDeNomes[j + 1] != null
                        && arrayDeNomes[j].compareTo(arrayDeNomes[j + 1]) > 0) {
                    aux = arrayDeNomes[j];
                    arrayDeNomes[j] = arrayDeNomes[j + 1];
                    arrayDeNomes[j + 1] = aux;
                }
            }
        }

        for (int i = 0; i < arrayDeNomes.length; i++) {
            if (arrayDeNomes[i] == null) {
            } else {
                nome += "Nome: " + arrayDeNomes[i] + "\n";
            }

        }
        if (nome == null) {
            JOptionPane.showMessageDialog(null, "Nenhum nome incontrado");
        } else {
            JOptionPane.showMessageDialog(null, nome);
        }
        return arrayDeNomes;
    }

    // Elemento atual é maior que o próximo? Se sim, troca a posição
    public static int[] ReorganizarSenhas(int[] array) {
        int aux = 0;
        String senhasC = null;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    aux = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = aux;
                }
            }
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
            } else {
                senhasC += "Senha :" + array[i] + "\n";
            }

        }

        if (senhasC == null) {
            JOptionPane.showMessageDialog(null, "Nenhuma senha Encontrada");
        } else {
            JOptionPane.showMessageDialog(null, senhasC);
        }

        return array;
    }
}
