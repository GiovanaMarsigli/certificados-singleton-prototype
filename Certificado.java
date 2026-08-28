/**
 * Padrão de Projeto: PROTOTYPE
 *
 * Permite criar um certificado "molde" (com a arte e os dados pesados
 * do curso já carregados) apenas UMA vez, e depois gerar cópias
 * (clones) independentes na memória para cada aluno, alterando
 * apenas o nome de quem vai receber — sem precisar consultar o
 * banco de dados novamente.
 */
public class Certificado implements Cloneable {

    private String nomeCurso;
    private String nomeAluno;

    /**
     * Cria o certificado "padrão"/original.
     * O nome do aluno começa em branco, pois ainda não foi personalizado.
     */
    public Certificado(String nomeCurso) {
        this.nomeCurso = nomeCurso;
        this.nomeAluno = "";
        System.out.println("[Certificado] Certificado ORIGINAL do curso \"" + nomeCurso + "\" carregado (simulando carga pesada do banco de dados).");
    }

    /**
     * Clona o certificado atual, gerando um novo objeto independente
     * na memória, com os mesmos dados do curso.
     */
    public Certificado clonar() {
        try {
            return (Certificado) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Erro ao clonar o certificado.", e);
        }
    }

    public void setNomeAluno(String nome) {
        this.nomeAluno = nome;
    }

    /**
     * Retorna os dados prontos do certificado, para envio à impressão.
     */
    public String getDados() {
        return "Certificado de Conclusão | Curso: " + nomeCurso + " | Aluno: " + nomeAluno;
    }
}
