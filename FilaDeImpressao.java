/**
 * Padrão de Projeto: SINGLETON
 *
 * Garante que exista apenas UMA única instância da fila de impressão
 * em toda a aplicação. Isso evita que múltiplas conexões com a
 * impressora central sejam abertas ao mesmo tempo, o que poderia
 * misturar documentos ou travar a impressora.
 */
public class FilaDeImpressao {

    // Única instância da classe, compartilhada por todo o sistema (estático)
    private static FilaDeImpressao instance;

    // Construtor privado: impede que outras classes façam "new FilaDeImpressao()"
    private FilaDeImpressao() {
        System.out.println("[FilaDeImpressao] Conexão com a impressora central estabelecida.");
    }

    /**
     * Ponto de acesso global à instância única.
     * Se ainda não existir, cria; se já existir, reaproveita a mesma.
     */
    public static FilaDeImpressao getInstance() {
        if (instance == null) {
            instance = new FilaDeImpressao();
        }
        return instance;
    }

    /**
     * Envia um documento para a fila/impressão.
     */
    public void imprimir(String documento) {
        System.out.println("[FilaDeImpressao] Imprimindo -> " + documento);
    }
}
