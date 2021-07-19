public class ContaBanco {

  //atributos
  public int numConta;
  private String tipo;
  private String dono;
  private float saldo;
  private boolean status;

  public static void main(String args[]) {
    //criação do objeto 1(pessoa1).
    ContaBanco p1 = new ContaBanco();
    p1.setNumConta(1111);
    p1.setDono("Otavio");

    //abrindo conta para a pessoa1(do tipo Conta Corrente)
    //quando abre uma conta do tipo Conta Corrente, a mesma começa com 50$
    p1.abrirConta("CC");                                  

    //depositando pessoa1
    p1.depositar(300f);

    //sacando pessoa1
    p1.sacar(150f);

    //imprimindo tabela de dados da conta da pessoa1
    p1.estadoAtual();

    //Criação do objeto 2(pessoa2)
    ContaBanco p2 = new ContaBanco();
    p2.setNumConta(2222);
    p2.setDono("Jesus");

    //abrindo conta para a pessoa2(do tipo Conta Poupança)
    //quando abre uma conta do tipo poupança, a mesma começa com 150$
    p2.abrirConta("CP");

    //depositando pessoa2
    p2.depositar(500f);

    //sacando pessoa2
    p2.sacar(100f);
    
    //mensalidade da conta, no caso da pessoa2(Conta Poupança) vai ser 20$ por mês
    p2.pagarMensal();

    p2.estadoAtual();

    //criação da pessoa3
    ContaBanco p3 = new ContaBanco();
    p3.setNumConta(3333);
    p3.setDono("Matheus");

    //abrindo conta para pessoa3
    p3.abrirConta("CP");

    //sacando todo dinheiro, para que seja possível fechar a conta sem erros (sem ter dinheiro ou débito com banco)
    p3.sacar(150f);
    //fechando conta
    p3.fecharConta();

    //tabela de dados
    p3.estadoAtual();
  }

  //métodos
  public void estadoAtual() {
    System.out.println("----------------------------");
    System.out.println("Conta: " + this.getNumConta());
    System.out.println("Tipo: " + this.getTipo());
    System.out.println("Dono: " + this.getDono());
    System.out.println("Saldo " + this.getSaldo());
    System.out.println("Status: " + this.getStatus());
    System.out.println("----------------------------");
  }

  public void abrirConta(String t) {
    this.setTipo(t);
    this.setStatus(true);

    if (t == "CC") {
      this.setSaldo(50f);
      System.out.println("Sucesso! A conta foi aberta.");
    } else if (t == "CP") {
      this.setSaldo(150f);
      System.out.println("Sucesso! A conta foi aberta.");
    }
  }

  public void fecharConta() {
    if (this.getSaldo() > 0) {
      System.out.println("A conta está com dinheiro, não pode ser fechada.");
    } else if (this.getSaldo() < 0) {
      System.out.println("A conta está em débito, não pode ser fechada.");
    } else {
      this.setStatus(false);
      System.out.println("A conta foi fechada com sucesso.");
    }
  }

  public void depositar(float v) {
    if (this.getStatus() == true) {
      this.setSaldo(this.getSaldo() + v);
      System.out.println("Depósito realizado na conta de\t" + this.getDono());
    } else {
      System.out.println("Impossível realizar o depósito.");
    }
  }

  public void sacar(float v) {
    if (this.getStatus()) { //maior igual? e ver pq tmb funciona getStatus(); somente assim ja sendo true
      if (this.getSaldo() >= v) {
        this.setSaldo(this.getSaldo() - v);
        System.out.println("Saque realizado na conta de\t" + this.getDono());
      } else {
        System.out.println("Saldo insuficiente para saque");
      }
    } else {
      System.out.println("Impossível realizar o saque");
    }
  }

  public void pagarMensal() {
    float v;

    if (this.getTipo() == "CC") {
      v = 12f;
    } else if (this.getTipo() == "CP") {
      v = 20f;
    } else {
      v = 0f;
    }

    if (this.getStatus()) {
      if (this.getSaldo() > v) {
        this.setSaldo(this.getSaldo() - v);
        System.out.println(
          "Mensalidade paga com sucesso por\t" + this.getDono()
        );
      } else {
        System.out.println("Saldo insuficiente");
      }
    } else {
      System.out.println("Impossíve pagar, a conta está fechada!");
    }
  }

  //construtor

  public ContaBanco() {
    this.saldo = 0f;
    this.status = false;
  }

  //set e get

  public int getNumConta() {
    return this.numConta;
  }

  public void setNumConta(int n) {
    this.numConta = n;
  }

  public String getTipo() {
    return this.tipo;
  }

  public void setTipo(String t) {
    this.tipo = t;
  }

  public String getDono() {
    return this.dono;
  }

  public void setDono(String d) {
    this.dono = d;
  }

  public float getSaldo() {
    return this.saldo;
  }

  public void setSaldo(float s) {
    this.saldo = s;
  }

  public boolean getStatus() {
    return this.status;
  }

  public void setStatus(boolean st) {
    this.status = st;
  }
}
