package entityBeans;

public class Conta {
  int numero;
  String dono;
  double saldo;
  double limite;
  Cliente titular = new Cliente(); //Quando fizerem um new Conta,
                                   //haver� um new Cliente para ele.
  
  //M�todo para sacar uma determinado valor de uma Conta;
  //Cria uma variavel double chamada "novoSaldo" e armazena o valor
  //de novoSaldo em this.saldo.
  //(Esse novoSaldo � o saldo corrente da Conta
  //menos a quantidade digitada pelo usu�rio.(valor sacado) 
  boolean saca(double valor) {
	if (this.saldo < valor) { 
	  return false;
	}
	else {
      this.saldo = this.saldo - valor;
      return true;
    }
  }
  
  //M�todo para depositar uma determinada quantia em uma conta.
  //Atualiza o atributo this.saldo com a quantia em dinheiro
  //selecionada para dep�sito.
  void deposita(double valor) {
    this.saldo += valor;	  
  }
  
  boolean transfere(Conta destino, double valor) {
    boolean retirou = this.saca(valor);
    if(retirou == false) {
      // n�o deu pra sacar!
      return false;	
    }
    else {
      destino.deposita(valor);
      return true;
    }
  }
}
