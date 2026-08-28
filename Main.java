public class Main {

    public static void main(String[] args) {

        System.out.println("===== 1. PREPARAÇÃO (Singleton) =====");
        // Solicita a instância única da FilaDeImpressao
        FilaDeImpressao fila = FilaDeImpressao.getInstance();

        System.out.println("\n===== 2. O MOLDE (Prototype) =====");
        // Cria o certificado original, apenas com o nome do curso.
        // O nome do aluno fica em branco.
        Certificado certificadoOriginal = new Certificado("Análise e Desenvolvimento de Sistemas");

        System.out.println("\n===== 3. A CLONAGEM =====");
        // Usa clonar() para criar duas cópias do certificado original
        Certificado clone1 = certificadoOriginal.clonar();
        Certificado clone2 = certificadoOriginal.clonar();

        System.out.println("\n===== 4. PERSONALIZAÇÃO =====");
        // Personaliza cada clone com o nome de um aluno diferente
        clone1.setNomeAluno("Ana Beatriz Souza");
        clone2.setNomeAluno("Carlos Eduardo Lima");

        System.out.println("\n===== 5. IMPRESSÃO =====");
        // Envia os dados de cada clone para a fila de impressão
        fila.imprimir(clone1.getDados());
        fila.imprimir(clone2.getDados());

        System.out.println("\n===== 6. VALIDAÇÃO DO PROTOTYPE =====");
        // Prova de que a clonagem gerou objetos independentes na memória
        System.out.println("Teste de memória (clone1 == clone2): " + (clone1 == clone2));

        System.out.println("\n===== 7. VALIDAÇÃO DO SINGLETON (extra) =====");
        // Solicita a instância novamente e confirma que é a mesma (mesmo endereço de memória)
        FilaDeImpressao filaNovamente = FilaDeImpressao.getInstance();
        System.out.println("Teste de memória (fila == filaNovamente): " + (fila == filaNovamente));
    }
}
