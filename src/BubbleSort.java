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
                    int e = LeituraDeDados();
                    if (e == 0) {
                        JOptionPane.showMessageDialog(null, "Opção Inválida...\n");
                    }
                    LerDados(e, arrayDeNomes, arrayDeSenhas);
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    arrayDeNomes = ReorganizarNomes(arrayDeNomes);
                    break;
                case 6:
                    arrayDeSenhas = ReorganizarSenhas(arrayDeSenhas);
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

    public static int LeituraDeDados() {
        int escolha = Integer.parseInt(JOptionPane.showInputDialog("1 - Ler Nomes\n2 - Ler Senhas"));
        if (escolha > 2 || escolha < 1) {
            return 0;
        }
        return escolha;
    }

    public static void LerDados(int escolha, String[] arrayNomes, int[] arraySenhas) {
        String nomes = "";
        String senhas = "";
        switch (escolha) {
            case 1:
                for (int i = 0; i < arrayNomes.length; i++) {
                    senhas += arrayNomes[i] + "\n";
                }
                if (senhas.length() > 0) {
                    JOptionPane.showMessageDialog(null, nomes);
                } else {
                    JOptionPane.showMessageDialog(null, "Nenhum dado encontrado!");
                }
            case 2:
                for (int i = 0; i < arraySenhas.length; i++) {
                    nomes += arraySenhas[i];
                }
                if (nomes.length() > 0) {
                    JOptionPane.showMessageDialog(null, senhas);
                } else {
                    JOptionPane.showMessageDialog(null, "Nenhum dado encontrado!");
                }
            case 3:
                for (int i = 0; i < arrayNomes.length; i++) {
                    nomes += arrayNomes[i];
                    JOptionPane.showMessageDialog(null, nomes);
                }
                for (int i = 0; i < arraySenhas.length; i++) {
                    senhas += arraySenhas;
                    JOptionPane.showMessageDialog(null, senhas);
                }
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opção Inválida...\n");
        }
    }

    // Elemento atual é maior que o próximo? Se sim, troca a posição
    public static int[] ReorganizarSenhas(int[] array) {
        int aux = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    aux = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = aux;
                }
            }
        }
        return array;
    }

    // Elemento atual é maior que o próximo (dentro da tabela ASCII)? Se sim, troca
    // a posição
    public static String[] ReorganizarNomes(String[] arrayDeNomes) {
        String aux = "";
        for (int i = 0; i < arrayDeNomes.length; i++) {
            for (int j = 0; j < arrayDeNomes.length - 1; j++) {
                if (arrayDeNomes[j] != null &&
                        arrayDeNomes[j + 1] != null &&
                        arrayDeNomes[j].compareTo(arrayDeNomes[j + 1]) > 0) {
                    aux = arrayDeNomes[j];
                    arrayDeNomes[j] = arrayDeNomes[j + 1];
                    arrayDeNomes[j + 1] = aux;
                }
            }
        }
        return arrayDeNomes;
    }
}