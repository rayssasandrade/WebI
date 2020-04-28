public class Usuario {
    private int codigo;
    private char nome;
    private char senha;

    public Usuario(int codigo, char nome, char senha) {
        this.codigo = codigo;
        this.nome = nome;
        this.senha = senha;
    }

    public void inserirUsuario(){

    }

    public void consultarUsuario(){

    }

    public void alterarUsuario(){

    }

    public void excluirUsuario(){

    }

    public void listarUsuario(){

    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public char getNome() {
        return nome;
    }

    public void setNome(char nome) {
        this.nome = nome;
    }

    public char getSenha() {
        return senha;
    }

    public void setSenha(char senha) {
        this.senha = senha;
    }
}
