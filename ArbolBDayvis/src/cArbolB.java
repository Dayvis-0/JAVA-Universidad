public class cArbolB {
    // atributos 
    //Prueba
    private Object aRaiz;
    private cArbolB aSubArbolIzq, aSubArbolDer;
    // constructor
    protected cArbolB() {
        aRaiz = null;
        aSubArbolIzq = null; aSubArbolDer = null;
    }
    // modificadores 
    public void mRaiz(Object pRaiz) { aRaiz = pRaiz; }
    public void mSubArbolIzq(cArbolB pSubArbolIzq) { aSubArbolIzq = pSubArbolIzq; }
    public void mSubArbolDere(cArbolB pSubArbolDer) { aSubArbolDer = pSubArbolDer; }
    // selelectores
    public Object sRaiz() { return aRaiz; }
    public cArbolB sSubArbolIzq() { return aSubArbolIzq; }
    public cArbolB sSubArbolDer() { return aSubArbolDer; }
    // metodos basicos
    public boolean estaVacio() { return (aRaiz == null); }
    public boolean agregar(Object pRaiz){
        boolean rta = false;
        if(estaVacio() ) {aRaiz = pRaiz; rta = true; }
        else {
            if (pRaiz.toString().compareTo(aRaiz.toString()) <= 0) { 
                if(aSubArbolIzq == null) { aSubArbolIzq = new cArbolB(); }
                rta = aSubArbolIzq.agregar(pRaiz);
            } else {
                if(aSubArbolDer == null) { aSubArbolDer = new cArbolB(); }
                rta = aSubArbolDer.agregar(pRaiz);
            }
        }
        return rta;
    }
    //
    public cArbolB maximo() {
        cArbolB rta = null;
        if(!estaVacio()) {
            if(aSubArbolDer == null) { rta = this; }
            else { rta = aSubArbolDer.maximo(); }
        } return rta;
    }
    public String maximoString(){
        String rta = "";
        if(!estaVacio()) {
            if(aSubArbolDer == null) { rta = aRaiz.toString(); }
            else { rta = aSubArbolDer.maximoString(); }
        } return rta;
    }
    public cArbolB minimo() {
        cArbolB rta = null;
        if(!estaVacio()) {
            if(aSubArbolIzq == null) { rta = this; }
            else { rta = aSubArbolIzq.minimo(); }
        } return rta;
    }
    private void limpiar() {
        if(!estaVacio()) {
            if(aSubArbolIzq != null) {
                if(aSubArbolIzq.sRaiz() == null) { aSubArbolIzq = null; }
                else {aSubArbolIzq.limpiar(); }
            }
            if(aSubArbolDer != null) {
                if(aSubArbolDer.sRaiz() == null) { aSubArbolDer = null; }
                else { aSubArbolDer.limpiar();}
            }
        }
    }
    public boolean eliminar(Object pRaiz) {
        boolean rta = false;
        if(!estaVacio()) {
            if(pRaiz.equals(aRaiz)) {
                rta = true; 
                if(aSubArbolIzq == null && aSubArbolDer == null) { 
                    aRaiz = null;
                } else if (aSubArbolIzq != null && aSubArbolDer != null) {
                    cArbolB dir = aSubArbolIzq.maximo();
                    aRaiz = dir.sRaiz();
                    aSubArbolIzq.eliminar(aRaiz);

                } else if (aSubArbolIzq != null) {
                    aRaiz = aSubArbolIzq.sRaiz(); 
                    aSubArbolDer = aSubArbolIzq.sSubArbolDer();
                    aSubArbolIzq = aSubArbolIzq.sSubArbolIzq();
                } else{
                    aRaiz = aSubArbolIzq.sRaiz();
                    aSubArbolIzq = aSubArbolDer.sSubArbolIzq();
                    aSubArbolDer = aSubArbolDer.sSubArbolDer();
                }
            } else {
                if(pRaiz.toString().compareTo(aRaiz.toString()) < 0){
                    if(aSubArbolIzq != null) {
                        rta = aSubArbolIzq.eliminar(pRaiz);
                    } else if(aSubArbolDer != null) {
                        rta = aSubArbolDer.eliminar(pRaiz);
                    }
                }
            }
            if(rta) {
                limpiar();
            }
        } return rta;
    }
    public String elementos() {
        String rta = "";
        if(!estaVacio()) {
            rta = aRaiz + " ";
            if(aSubArbolIzq != null) { rta = rta + aSubArbolIzq.elementos(); }
            if(aSubArbolDer != null) { rta = rta + aSubArbolDer.elementos(); }
        } return rta;
    }
    public cArbolB arbol(Object pRaiz){
        cArbolB rta = null;
        if(!estaVacio()) {
            if(pRaiz.equals(aRaiz)){
                rta = this;
            } else { 
                if(pRaiz.toString().compareTo(aRaiz.toString()) < 0) {
                    if(aSubArbolIzq != null) { rta = aSubArbolIzq.arbol(pRaiz); }
                }
                else if (aSubArbolDer != null) { rta = aSubArbolDer.arbol(pRaiz); }
            }
        } return rta;
    }
    public boolean existe(Object pRaiz) {
        boolean rta = false;
        if(!estaVacio()) {
            if(pRaiz.equals(aRaiz)){ rta = true; }
            else {
                if(pRaiz.toString().compareTo(aRaiz.toString()) < 0) {
                    if(aSubArbolIzq != null){ rta = aSubArbolIzq.existe(pRaiz); }
                }
                else {
                    if(aSubArbolDer != null){ rta = aSubArbolDer.existe(pRaiz); }
                }
            }
        } return rta;
    }
    public String preOrden() {
        String rta = "";
        if(!estaVacio()){
            rta = aRaiz + " ";
            if(aSubArbolIzq != null) { rta = rta + aSubArbolIzq.preOrden(); }
            if(aSubArbolDer != null) { rta = rta + aSubArbolDer.preOrden(); }
        } return rta;
    }  
    public String inOrden() {
        String rta = "";
        if(!estaVacio()){
            if(aSubArbolIzq != null) { rta = aSubArbolIzq.inOrden(); }
            rta = rta  + " " + aRaiz;
            if(aSubArbolDer != null) { rta = rta + aSubArbolDer.inOrden(); }
        } return rta;
    }  
    public String posOrden() {
        String rta = "";
        if(!estaVacio()){
            if(aSubArbolIzq != null) { rta = rta + aSubArbolIzq.posOrden(); }
            if(aSubArbolDer != null) { rta = rta + aSubArbolDer.posOrden(); }
            rta = rta + aRaiz + " ";
        } return rta;
    }  
    public boolean esPadre(Object pRaiz) {
        boolean rta = false;
        if(!estaVacio()) {
            if(aRaiz.equals(pRaiz)){
                if(aSubArbolIzq != null ||aSubArbolDer != null) { rta = true; }
            } else {
                if(pRaiz.toString().compareTo(aRaiz.toString()) < 0) {
                    if(aSubArbolIzq != null) { rta = aSubArbolIzq.esPadre(pRaiz); }         
                }else if(!rta && aSubArbolDer != null ) { rta = aSubArbolDer.esPadre(pRaiz); }
            }
        } return rta;
    }
    public boolean esHoja(Object pRaiz) {
        boolean rta = false;
        if(!estaVacio()) {
            if(aRaiz.equals(pRaiz)){
                if(aSubArbolIzq == null && aSubArbolDer == null) { rta = true; }
            } else {
                if(aSubArbolIzq != null) { rta = aSubArbolIzq.esHoja(pRaiz); }
                if(!rta && aSubArbolDer != null) { rta = aSubArbolDer.esHoja(pRaiz); }
            }
        } return rta;
    }
    public int altura() {
        int altIzq = 0, altDer = 0;
        if(!estaVacio()) {
            if(aSubArbolIzq != null) { altIzq = 1 + aSubArbolIzq.altura(); }
            if(aSubArbolDer != null) { altDer = 1 + aSubArbolDer.altura(); }
        }return (altIzq > altDer ? altIzq : altDer);
    }
    public int nivel (Object pRaiz, int pNivel) {
        int rta = -1;
        if(!estaVacio()) {
            if(aRaiz.equals(pRaiz)) { rta = pNivel; }
            else {
                if(pRaiz.toString().compareTo(aRaiz.toString()) < 0) {
                    if(aSubArbolIzq != null) { rta = aSubArbolIzq.nivel(pRaiz, pNivel + 1); }
                } else {
                    if(aSubArbolDer != null) { rta = aSubArbolDer.nivel(pRaiz, pNivel + 1); }
                }    
            }
        } return rta;
    }
    public String recorrerPadre() {
        String rta = "";
        if(!estaVacio()) {
            if(aSubArbolIzq != null || aSubArbolDer != null) { rta = aRaiz + " "; }
            if(aSubArbolIzq != null) { rta = rta + aSubArbolIzq.recorrerPadre(); }
            if(aSubArbolDer != null) { rta = rta + aSubArbolDer.recorrerPadre(); }
        }
        return rta; 
    }
    public String recorrerHoja() {
        String rta = "";
        if(!estaVacio()) {
            if(aSubArbolIzq == null && aSubArbolDer == null) { rta = aRaiz + " "; }
            else {
                if(aSubArbolIzq != null) { rta = aSubArbolIzq.recorrerHoja(); }
                if(aSubArbolDer != null) { rta = aSubArbolDer.recorrerHoja(); }
            }
        } return rta; 
    }
    public int padres() {
        int rta = 0;
        if(!estaVacio()) {
            if(aSubArbolIzq != null || aSubArbolDer != null) { rta = 1; }
            if(aSubArbolIzq != null ) { rta = rta + aSubArbolIzq.padres(); }
            if(aSubArbolDer != null) { rta = rta + aSubArbolDer.padres(); }
        }return rta;
    }
    public int hojas() {
        int rta = 0;
        if(!estaVacio()) {
            if(aSubArbolIzq == null && aSubArbolDer == null) { rta = 1; }
            if(aSubArbolIzq != null ) { rta = rta + aSubArbolIzq.hojas(); }
            if(aSubArbolDer != null) { rta = rta + aSubArbolDer.hojas(); }
        }return rta;
    } 
    public String suPadre(Object pRaiz) {
        String rta = "No tiene padres";
        if(!estaVacio()){
            if((aSubArbolIzq != null && aSubArbolIzq.sRaiz().equals(pRaiz)) || (aSubArbolDer != null && aSubArbolDer.sRaiz().equals(pRaiz))) { rta = aRaiz.toString(); }
            else {
                if(pRaiz.toString().compareTo(aRaiz.toString()) < 0 ) {
                    if(aSubArbolIzq != null) { rta = aSubArbolIzq.suPadre(pRaiz); }
                }
                else {
                    if(aSubArbolDer != null) { rta = aSubArbolDer.suPadre(pRaiz); }
                }
            }
        }
        return rta;
    }
    public Object padre(Object pRaiz) {
        Object rta = null;
        if(!estaVacio()) {
            if(pRaiz.toString().compareTo(aRaiz.toString()) < 0) {
                if(aSubArbolIzq != null) {
                    if(aSubArbolIzq.sRaiz().equals(pRaiz)) { rta = this; }
                    else{ rta = aSubArbolIzq.padre(pRaiz); } 
                }
            }
            else if (aSubArbolDer != null){
                if(aSubArbolDer.sRaiz().equals(pRaiz)) { rta = this; }
                else { rta = aSubArbolDer.padre(pRaiz); }
            }
        }
        return rta;
    }
    public String recorrerPrimerHijo() {
        String rta = "";
        if(!estaVacio()) {
            if(aSubArbolIzq != null) {
                rta = rta + aSubArbolIzq.sRaiz().toString() + " ";
                rta = rta + aSubArbolIzq.recorrerPrimerHijo();
            }
            if(aSubArbolDer != null) {
                rta = rta + aSubArbolDer.recorrerPrimerHijo();
            }
        }
        return rta;
    }
    public String recorrerSegundoHijo() {
        String rta = "";
        if(!estaVacio()) {
            if(aSubArbolDer != null) {
                rta = rta + aSubArbolDer.sRaiz().toString() + " ";
                rta = rta + aSubArbolDer.recorrerSegundoHijo();
            }
            if(aSubArbolIzq != null) {
                rta = rta + aSubArbolIzq.recorrerSegundoHijo();
            }
        }
        return rta;
    }
    public boolean esHermano(Object pRaiz) {
        boolean rta = false;
        if(!estaVacio()) {
            if(aSubArbolIzq != null && aSubArbolIzq.sRaiz().equals(pRaiz)) { rta = (aSubArbolDer != null); }
            else if((aSubArbolDer != null && aSubArbolDer.sRaiz().equals(pRaiz))) {
                rta = (aSubArbolIzq != null);
            }
            else {
                if(pRaiz.toString().compareTo(aRaiz.toString()) < 0) {
                    if(aSubArbolIzq != null) { rta = aSubArbolIzq.esHermano(pRaiz);}
                }else {
                    if(aSubArbolDer != null) { rta = aSubArbolDer.esHermano(pRaiz); }
                }
            }
        } return rta;       
    }
    public String recorrerUltimoHijo() {
        String rta = "";
        if(!estaVacio()){
            if(aSubArbolDer != null){ 
                rta = rta + aSubArbolDer.sRaiz().toString() + " ";
                rta = rta + aSubArbolDer.recorrerUltimoHijo();
            }
            else if(aSubArbolIzq != null) {
                rta = rta + aSubArbolIzq.sRaiz().toString() + " ";
                rta = rta + aSubArbolIzq.recorrerUltimoHijo();
            }
        } return rta;
    }
    public String recorrerHijoUnico() {
        String rta = "";
        if (!estaVacio()) {
            if (aSubArbolIzq != null && aSubArbolDer == null) {
                rta += aSubArbolIzq.sRaiz().toString() + " ";
                rta += aSubArbolIzq.recorrerHijoUnico();
            }
            else if (aSubArbolIzq == null && aSubArbolDer != null) {
                rta += aSubArbolDer.sRaiz().toString() + " ";
                rta += aSubArbolDer.recorrerHijoUnico();
            }
            else if (aSubArbolIzq != null && aSubArbolDer != null) {
                rta += aSubArbolIzq.recorrerHijoUnico();
                rta += aSubArbolDer.recorrerHijoUnico();
            }
        }
        return rta;
    }
    public String recorrerRaizDiferencia() {
        String rta = "";
        if(!estaVacio()){
            if(aSubArbolIzq != null && aSubArbolDer != null) {
                int izq = Integer.parseInt(aSubArbolIzq.sRaiz().toString());
                int raiz = Integer.parseInt(aRaiz.toString());
                int der = Integer.parseInt(aSubArbolDer.sRaiz().toString());
                if(raiz == der-izq) { rta = raiz + " "; }
            }
            if(aSubArbolIzq != null) { rta = rta + aSubArbolIzq.recorrerRaizDiferencia(); }
            if(aSubArbolDer != null) { rta = rta + aSubArbolDer.recorrerRaizDiferencia(); }
        }return rta;
    }
    public String recorrerSubArbolDiferencia() {
        String rta = "";
        if(!estaVacio()){
            if(aSubArbolIzq != null && aSubArbolDer != null) {
                int izq = Integer.parseInt(aSubArbolIzq.sRaiz().toString());
                int raiz = Integer.parseInt(aRaiz.toString());
                int der = Integer.parseInt(aSubArbolDer.sRaiz().toString());
                if(raiz == der-izq) { rta = "(" + izq + " - " + der + ")";}
            }
            if(aSubArbolIzq != null) { rta = rta + aSubArbolIzq.recorrerSubArbolDiferencia(); }
            if(aSubArbolDer != null) { rta = rta + aSubArbolDer.recorrerSubArbolDiferencia(); }
        }return rta;
    }
    public String rRD() {
        String rta = "";
        if(!estaVacio()){
            if(aSubArbolIzq != null && aSubArbolDer != null) {
                if(((Integer.parseInt(aSubArbolDer.sRaiz().toString()))- (Integer.parseInt(aSubArbolIzq.sRaiz().toString()))) == (Integer.parseInt(aRaiz.toString()))) {
                    rta = aRaiz + " ";
                }
            }
            if(aSubArbolIzq != null) { rta = rta + aSubArbolIzq.rRD(); }
            if(aSubArbolDer != null) { rta = rta + aSubArbolDer.rRD(); }
        }return rta;
    }
    public String rSAD() {
        String rta = "";
        if(!estaVacio()){
            if(aSubArbolIzq != null && aSubArbolDer != null) {
                if(((Integer.parseInt(aSubArbolDer.sRaiz().toString()))- (Integer.parseInt(aSubArbolIzq.sRaiz().toString()))) == (Integer.parseInt(aRaiz.toString()))) {
                    rta = aSubArbolDer.sRaiz().toString() + aSubArbolIzq.sRaiz().toString() + " ";
                }
            }
            if(aSubArbolIzq != null) { rta = rta + aSubArbolIzq.rSAD(); }
            if(aSubArbolDer != null) { rta = rta + aSubArbolDer.rSAD(); }
        }return rta;
    }
    public static void main(String[] args) {
        cArbolB arb1 = new cArbolB();

        arb1.agregar("4");
        arb1.agregar("2");
        arb1.agregar("6");


        System.out.println("Raiz diferencia: " + arb1.recorrerRaizDiferencia());
        System.out.println("Sub arbol diferencia: " + arb1.recorrerSubArbolDiferencia());
        System.out.println("Raiz diferencia: " + arb1.rRD());
        System.out.println("Sub arbol diferencia: " + arb1.rSAD());
    }   
}