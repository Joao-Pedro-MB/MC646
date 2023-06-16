package com.mc646;

import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.core.condition.EdgeCoverage;
import org.graphwalker.core.condition.ReachedVertex;
import org.graphwalker.core.generator.RandomPath;
import org.graphwalker.core.generator.SingletonRandomGenerator;
import org.graphwalker.java.annotation.Edge;
import org.graphwalker.java.annotation.GraphWalker;
import org.graphwalker.java.annotation.Model;
import org.graphwalker.java.test.TestBuilder;
import org.graphwalker.java.test.TestExecutor;
import org.graphwalker.java.test.Result;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

@GraphWalker(value = "quick_random(edge_coverage(100))", start = "v_Inicializa")
public class BoundedQueueTest extends ExecutionContext implements BoundedQueueTestModelInterface {
	
 public final static Path MODEL_PATH = Paths.get("resources/com/mc646/execicio11.json");
 BoundedQueue boundedQueue = null;
 int element1 = 1;
 boolean nullPointerException = false;
 boolean illegalStateException = false;
 
 @Override
 public void v_Inicializa() {
   System.out.println("Running: v_Inicializa");
   Assertions.assertNull(boundedQueue);
 }
 
 @Override
 public void e_Reinicia() {
	   System.out.println("Running: e_Reinicia");
	   boundedQueue = null;
	   nullPointerException = false;
	   illegalStateException = false;
 }

 @Override
 public void e_Enfileira() {
	   System.out.println("Running: e_Enfileira");
	   boundedQueue.enQueue(element1);
 }

 @Override
 public void e_EnfileiraCheio() {
	 System.out.println("Running: e_EnfileiraCheio");
	 try {
		  boundedQueue.enQueue(element1);
		}
		catch(IllegalStateException e) {
		  illegalStateException = true;
		}
}
 
 @Override
 public void e_EnfileiraNulo() {
	 System.out.println("Running: e_EnfileiraNulo");
	 try {
		 boundedQueue.enQueue(null);
	 } catch (NullPointerException e) {
		 nullPointerException = true;
	 }
 }

 @Override
 public void e_EnfileiraExcecao() {
	 System.out.println("Running: e_EnfileiraExcecao");
	 try {
		 boundedQueue.enQueue(element1);
		 
	 } catch (IllegalStateException e) {
		 illegalStateException = true;
	 }
 }

 @Override
 public void e_EnfileiraNaoCheio() {
		   System.out.println("Running: e_EnfileiraNaoCheio");
		   boundedQueue.enQueue(element1);
 }
 
 @Override
 public void v_FilaCheia() {
	   System.out.println("Running: v_FilaCheia");
	   Assertions.assertTrue(boundedQueue.isFull());
 }

 @Override
 public void v_NullPointerException() {
	   System.out.println("Running: v_NullPointerException");
	   Assertions.assertTrue(nullPointerException);
 }
 
 @Override
 public void e_DesenfileiraVazio() {
	 System.out.println("Running: e_DesenfileiraVazio");
	 try {
		 boundedQueue.deQueue();
	 } catch(IllegalStateException e) {
		 illegalStateException = true;
	 }
 }

 @Override
 public void e_Desenfileira() {
	   System.out.println("Running: e_Desenfileira");
	   boundedQueue.deQueue();   
 }

 @Override
 public void e_DesenfileiraNaoCheio() {
	   System.out.println("Running: e_DesenfileiraNaoCheio");
	   boundedQueue.deQueue();   
 }
 
 @Override
 public void v_FilaVazia() {
	   System.out.println("Running: v_FilaVazia");
	   Assertions.assertTrue(boundedQueue.isEmpty());
 }

 @Override
 public void e_criaBoundedQueue() {
	   System.out.println("Running: e_criaBoundedQueue");
	   boundedQueue = new BoundedQueue(6);
 }

 @Override
 public void v_FilaNaoCheia() {
	   System.out.println("Running: v_FilaNaoCheia");
	   Assertions.assertFalse(boundedQueue.isFull());
	   Assertions.assertFalse(boundedQueue.isEmpty());
 }

 @Override
 public void v_ExecaoIlegalState() {
	 System.out.println("Running: v_ExecaoIlegalState");
	 Assertions.assertTrue(illegalStateException);
 }

@Test
public void TestPath() {
	v_Inicializa();
	e_criaBoundedQueue();
	v_FilaVazia();
	e_Enfileira();
	v_FilaNaoCheia();
	e_EnfileiraNulo();
	v_NullPointerException();
	e_Reinicia();
	v_Inicializa();
	e_criaBoundedQueue();
	v_FilaVazia();
	e_DesenfileiraVazio();
	v_ExecaoIlegalState();
	e_Reinicia();
	v_Inicializa();
	e_criaBoundedQueue();
	v_FilaVazia();
	e_EnfileiraNulo();
	v_NullPointerException();
	e_Reinicia();
	v_Inicializa();
	e_criaBoundedQueue();
	v_FilaVazia();
	e_DesenfileiraVazio();
	v_ExecaoIlegalState();
	e_Reinicia();
	v_Inicializa();
	e_criaBoundedQueue();
	v_FilaVazia();
	e_DesenfileiraVazio();
	v_ExecaoIlegalState();
	e_Reinicia();
	v_Inicializa();
	e_criaBoundedQueue();
	v_FilaVazia();
	e_EnfileiraNulo();
	v_NullPointerException();
	e_Reinicia();
	v_Inicializa();
	e_criaBoundedQueue();
	v_FilaVazia();
	e_DesenfileiraVazio();
	v_ExecaoIlegalState();
	e_Reinicia();
	v_Inicializa();
	e_criaBoundedQueue();
	v_FilaVazia();
	e_Enfileira();
	v_FilaNaoCheia();
	e_EnfileiraNulo();
	v_NullPointerException();
	e_Reinicia();
	v_Inicializa();
	e_criaBoundedQueue();
	v_FilaVazia();
	e_Enfileira();
	v_FilaNaoCheia();
	e_EnfileiraNaoCheio();
	v_FilaNaoCheia();
	e_EnfileiraNulo();
	v_NullPointerException();
	e_Reinicia();
	v_Inicializa();
	e_criaBoundedQueue();
	v_FilaVazia();
	e_DesenfileiraVazio();
	v_ExecaoIlegalState();
	e_Reinicia();
	v_Inicializa();
	e_criaBoundedQueue();
	v_FilaVazia();
	e_DesenfileiraVazio();
	v_ExecaoIlegalState();
	e_Reinicia();
	v_Inicializa();
	e_criaBoundedQueue();
	v_FilaVazia();
	e_EnfileiraNulo();
	v_NullPointerException();
	e_Reinicia();
	v_Inicializa();
	e_criaBoundedQueue();
	v_FilaVazia();
	e_EnfileiraNulo();
	v_NullPointerException();
	e_Reinicia();
	v_Inicializa();
	e_criaBoundedQueue();
	v_FilaVazia();
	e_DesenfileiraVazio();
	v_ExecaoIlegalState();
	e_Reinicia();
	v_Inicializa();
	e_criaBoundedQueue();
	v_FilaVazia();
	e_EnfileiraNulo();
	v_NullPointerException();
	e_Reinicia();
	v_Inicializa();
	e_criaBoundedQueue();
	v_FilaVazia();
	e_DesenfileiraVazio();
	v_ExecaoIlegalState();
	e_Reinicia();
	v_Inicializa();
	e_criaBoundedQueue();
	v_FilaVazia();
	e_Enfileira();
	v_FilaNaoCheia();
	e_EnfileiraNulo();
	v_NullPointerException();
	e_Reinicia();
	v_Inicializa();
	e_criaBoundedQueue();
	v_FilaVazia();
	e_Enfileira();
	v_FilaNaoCheia();
	e_EnfileiraNulo();
	v_NullPointerException();
	e_Reinicia();
	v_Inicializa();
	e_criaBoundedQueue();
	v_FilaVazia();
	e_Enfileira();
	v_FilaNaoCheia();
	e_EnfileiraNulo();
	v_NullPointerException();
	e_Reinicia();
	v_Inicializa();
	e_criaBoundedQueue();
	v_FilaVazia();
	e_EnfileiraNulo();
	v_NullPointerException();
	e_Reinicia();
	v_Inicializa();
	e_criaBoundedQueue();
	v_FilaVazia();
	e_EnfileiraNulo();
	v_NullPointerException();
	e_Reinicia();
	v_Inicializa();
	e_criaBoundedQueue();
	v_FilaVazia();
	e_Enfileira();
	v_FilaNaoCheia();
	e_EnfileiraNulo();
	v_NullPointerException();
	e_Reinicia();
	v_Inicializa();
	e_criaBoundedQueue();
	v_FilaVazia();
	e_EnfileiraNulo();
	v_NullPointerException();
	e_Reinicia();
	v_Inicializa();
	e_criaBoundedQueue();
	v_FilaVazia();
	e_DesenfileiraVazio();
	v_ExecaoIlegalState();
	e_Reinicia();
	v_Inicializa();
	e_criaBoundedQueue();
	v_FilaVazia();
	e_EnfileiraNulo();
	v_NullPointerException();
	e_Reinicia();
	v_Inicializa();
	e_criaBoundedQueue();
	v_FilaVazia();
	e_DesenfileiraVazio();
	v_ExecaoIlegalState();
	e_Reinicia();
	v_Inicializa();
	e_criaBoundedQueue();
	v_FilaVazia();
	e_Enfileira();
	v_FilaNaoCheia();
	e_EnfileiraNulo();
	v_NullPointerException();
	e_Reinicia();
	v_Inicializa();
	e_criaBoundedQueue();
	v_FilaVazia();
	e_DesenfileiraVazio();
	v_ExecaoIlegalState();
	e_Reinicia();
	v_Inicializa();
	e_criaBoundedQueue();
	v_FilaVazia();
	e_DesenfileiraVazio();
	v_ExecaoIlegalState();
	e_Reinicia();
	v_Inicializa();
	e_criaBoundedQueue();
	v_FilaVazia();
	e_EnfileiraNulo();
	v_NullPointerException();
	e_Reinicia();
	v_Inicializa();
	e_criaBoundedQueue();
	v_FilaVazia();
	e_EnfileiraNulo();
	v_NullPointerException();
	e_Reinicia();
	v_Inicializa();
	e_criaBoundedQueue();
	v_FilaVazia();
	e_Enfileira();
	v_FilaNaoCheia();
	e_EnfileiraNulo();
	v_NullPointerException();
	e_Reinicia();
	v_Inicializa();
	e_criaBoundedQueue();
	v_FilaVazia();
	e_Enfileira();
	v_FilaNaoCheia();
	e_EnfileiraNaoCheio();
	v_FilaNaoCheia();
	e_EnfileiraNaoCheio();
	v_FilaNaoCheia();
	e_EnfileiraNulo();
	v_NullPointerException();
	e_Reinicia();
	v_Inicializa();
	e_criaBoundedQueue();
	v_FilaVazia();
	e_DesenfileiraVazio();
	v_ExecaoIlegalState();
	e_Reinicia();
	v_Inicializa();
	e_criaBoundedQueue();
	v_FilaVazia();
	e_DesenfileiraVazio();
	v_ExecaoIlegalState();
	e_Reinicia();
	v_Inicializa();
	e_criaBoundedQueue();
	v_FilaVazia();
	e_Enfileira();
	v_FilaNaoCheia();
	e_EnfileiraNaoCheio();
	v_FilaNaoCheia();
	e_EnfileiraNaoCheio();
	v_FilaNaoCheia();
	e_DesenfileiraNaoCheio();
	v_FilaNaoCheia();
	e_DesenfileiraNaoCheio();
	v_FilaNaoCheia();
	e_EnfileiraNaoCheio();
	v_FilaNaoCheia();
	e_EnfileiraNulo();
	v_NullPointerException();
	e_Reinicia();
	v_Inicializa();
	e_criaBoundedQueue();
	v_FilaVazia();
	e_DesenfileiraVazio();
	v_ExecaoIlegalState();
	e_Reinicia();
	v_Inicializa();
	e_criaBoundedQueue();
	v_FilaVazia();
	e_EnfileiraNulo();
	v_NullPointerException();
	e_Reinicia();
	v_Inicializa();
	e_criaBoundedQueue();
	v_FilaVazia();
	e_EnfileiraNulo();
	v_NullPointerException();
	e_Reinicia();
	v_Inicializa();
	e_criaBoundedQueue();
	v_FilaVazia();
	e_DesenfileiraVazio();
	v_ExecaoIlegalState();
	e_Reinicia();
	v_Inicializa();
	e_criaBoundedQueue();
	v_FilaVazia();
	e_Enfileira();
	v_FilaNaoCheia();
	e_EnfileiraNulo();
	v_NullPointerException();
	e_Reinicia();
	v_Inicializa();
	e_criaBoundedQueue();
	v_FilaVazia();
	e_Enfileira();
	v_FilaNaoCheia();
	e_DesenfileiraVazio();
	v_FilaVazia();
	e_Enfileira();
	v_FilaNaoCheia();
	e_DesenfileiraVazio();
	v_FilaVazia();
	e_EnfileiraNulo();
	v_NullPointerException();
	e_Reinicia();
	v_Inicializa();
	e_criaBoundedQueue();
	v_FilaVazia();
	e_EnfileiraNulo();
	v_NullPointerException();
	e_Reinicia();
	v_Inicializa();
	e_criaBoundedQueue();
	v_FilaVazia();
	e_Enfileira();
	v_FilaNaoCheia();
	e_EnfileiraNaoCheio();
	v_FilaNaoCheia();
	e_EnfileiraNaoCheio();
	v_FilaNaoCheia();
	e_EnfileiraNulo();
	v_NullPointerException();
	e_Reinicia();
	v_Inicializa();
	e_criaBoundedQueue();
	v_FilaVazia();
	e_EnfileiraNulo();
	v_NullPointerException();
	e_Reinicia();
	v_Inicializa();
	e_criaBoundedQueue();
	v_FilaVazia();
	e_Enfileira();
	v_FilaNaoCheia();
	e_EnfileiraNulo();
	v_NullPointerException();
	e_Reinicia();
	v_Inicializa();
	e_criaBoundedQueue();
	v_FilaVazia();
	e_Enfileira();
	v_FilaNaoCheia();
	e_DesenfileiraNaoCheio();
	v_FilaNaoCheia();
	e_EnfileiraCheio();
	v_FilaCheia();
	e_EnfileiraExcecao();
	v_ExecaoIlegalState();
	e_Reinicia();
	v_Inicializa();
	e_criaBoundedQueue();
	v_FilaVazia();
	e_Enfileira();
	v_FilaNaoCheia();
	e_EnfileiraNulo();
	v_NullPointerException();
	e_Reinicia();
	v_Inicializa();
	e_criaBoundedQueue();
	v_FilaVazia();
	e_DesenfileiraVazio();
	v_ExecaoIlegalState();
	e_Reinicia();
	v_Inicializa();
	e_criaBoundedQueue();
	v_FilaVazia();
	e_EnfileiraNulo();
	v_NullPointerException();
	e_Reinicia();
	v_Inicializa();
	e_criaBoundedQueue();
	v_FilaVazia();
	e_EnfileiraNulo();
	v_NullPointerException();
	e_Reinicia();
	v_Inicializa();
	e_criaBoundedQueue();
	v_FilaVazia();
	e_EnfileiraNulo();
	v_NullPointerException();
	e_Reinicia();
	v_Inicializa();
	e_criaBoundedQueue();
	v_FilaVazia();
	e_EnfileiraNulo();
	v_NullPointerException();
	e_Reinicia();
	v_Inicializa();
	e_criaBoundedQueue();
	v_FilaVazia();
	e_Enfileira();
	v_FilaNaoCheia();
	e_EnfileiraNulo();
	v_NullPointerException();
	e_Reinicia();
	v_Inicializa();
	e_criaBoundedQueue();
	v_FilaVazia();
	e_Enfileira();
	v_FilaNaoCheia();
	e_EnfileiraNulo();
	v_NullPointerException();
	e_Reinicia();
	v_Inicializa();
	e_criaBoundedQueue();
	v_FilaVazia();
	e_Enfileira();
	v_FilaNaoCheia();
	e_DesenfileiraNaoCheio();
	v_FilaNaoCheia();
	e_DesenfileiraNaoCheio();
	v_FilaNaoCheia();
	e_EnfileiraNulo();
	v_NullPointerException();
	e_Reinicia();
	v_Inicializa();
	e_criaBoundedQueue();
	v_FilaVazia();
	e_DesenfileiraVazio();
	v_ExecaoIlegalState();
	e_Reinicia();
	v_Inicializa();
	e_criaBoundedQueue();
	v_FilaVazia();
	e_DesenfileiraVazio();
	v_ExecaoIlegalState();
	e_Reinicia();
	v_Inicializa();
	e_criaBoundedQueue();
	v_FilaVazia();
	e_Enfileira();
	v_FilaNaoCheia();
	e_EnfileiraNulo();
	v_NullPointerException();
	e_Reinicia();
	v_Inicializa();
	e_criaBoundedQueue();
	v_FilaVazia();
	e_DesenfileiraVazio();
	v_ExecaoIlegalState();
	e_Reinicia();
	v_Inicializa();
	e_criaBoundedQueue();
	v_FilaVazia();
	e_Enfileira();
	v_FilaNaoCheia();
	e_EnfileiraNulo();
	v_NullPointerException();
	e_Reinicia();
	v_Inicializa();
	e_criaBoundedQueue();
	v_FilaVazia();
	e_Enfileira();
	v_FilaNaoCheia();
	e_DesenfileiraNaoCheio();
	v_FilaNaoCheia();
	e_DesenfileiraNaoCheio();
	v_FilaNaoCheia();
	e_DesenfileiraNaoCheio();
	v_FilaNaoCheia();
	e_EnfileiraCheio();
	v_FilaCheia();
	e_Desenfileira();
	v_FilaNaoCheia();
	e_EnfileiraCheio();
	v_FilaCheia();
	e_Desenfileira();
	v_FilaNaoCheia();
	e_EnfileiraCheio();
	v_FilaCheia();
	e_EnfileiraNulo();
	v_NullPointerException();
}

}
