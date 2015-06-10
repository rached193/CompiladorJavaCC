package Practica2;

public class TablaHash {
	private static int tamaño = 256;
	private static int T[] = { 98,
			6,
			85,
			150,
			36,
			23,
			112,
			164,
			135,
			207,
			169,
			5,
			26,
			64,
			165,
			219, // 1
			61, 20,
			68,
			89,
			130,
			63,
			52,
			102,
			24,
			229,
			132,
			245,
			80,
			216,
			195,
			115, // 2
			90, 168, 156,
			203,
			177,
			120,
			2,
			190,
			188,
			7,
			100,
			185,
			174,
			243,
			162,
			10, // 3
			237, 18, 253, 225,
			8,
			208,
			172,
			244,
			255,
			126,
			101,
			79,
			145,
			235,
			228,
			121, // 4
			123, 251, 67, 250, 161,
			0,
			107,
			97,
			241,
			111,
			181,
			82,
			249,
			33,
			69,
			55, // 5
			59, 153, 29, 9, 213, 167,
			84,
			93,
			30,
			46,
			94,
			75,
			151,
			114,
			73,
			222, // 6
			197, 96, 210, 45, 16, 227, 248,
			202,
			51,
			152,
			252,
			125,
			81,
			206,
			215,
			186, // 7
			39, 158, 178, 187, 131, 136, 1, 49,
			50,
			17,
			141,
			91,
			47,
			129,
			60,
			99, // 8
			154, 35, 86, 171, 105, 34, 38, 200, 147,
			58,
			77,
			118,
			173,
			246,
			76,
			254, // 9
			133, 232, 196, 144, 198, 124, 53, 4, 108, 74,
			223,
			234,
			134,
			230,
			157,
			139, // 10
			189, 205, 199, 128, 176, 19, 211, 236, 127, 192, 231,
			70,
			233,
			88,
			146,
			44, // 11
			183, 201, 22, 83, 13, 214, 116, 109, 159, 32, 95, 226,
			140,
			220,
			57,
			12, // 12
			221, 31, 209, 182, 143, 92, 149, 184, 148, 62, 113, 65, 37,
			27,
			106,
			166, // 13
			3, 14, 204, 72, 21, 41, 56, 66, 28, 193, 40, 217, 25, 54,
			179,
			117, // 14
			238, 87, 240, 155, 180, 170, 242, 212, 191, 163, 78, 218, 137, 194,
			175,
			110, // 15
			43, 119, 224, 71, 122, 142, 42, 160, 104, 48, 247, 103, 15, 11,
			138, 239 // 16
	};

	private Par[] tabla;

	public TablaHash() {
		this.tabla = new Par[tamaño];
	}

	private static int hashCode(String asx) {// Person
		int h = 0;
		for (int i = 0; i < asx.length(); i++) {
			h = T[h ^ asx.charAt(i)];
		}
		return h;

	}

	// Insertar no Verifica si ya exite el elemento
	public void insertar(Simbolo sim) {
		//System.out.println("Inserto simbolo: "+ sim.getNombre()+" en el nivel:"+ sim.getNivel());
		int hash = hashCode(sim.getNombre());
		Par paux = new Par(sim.getNombre(), sim);

		Par iter = tabla[hash];
		if (iter == null) {
			tabla[hash] = paux;
		} else {
			paux.setSiguiente(iter);
			tabla[hash] = paux;
		}
	}

	public Simbolo buscar(String nom) {
		int hash = hashCode(nom);
		Par iter = tabla[hash];
		Simbolo saux = null;
		boolean termina = false;
		while ((iter != null) && (!termina)) {
			if (iter.getValor().getNombre().equals(nom)) {
				termina = true;
				saux = iter.getValor();
			}
			iter = iter.getSiguiente();
		}
		return saux;
	}

	public boolean existe(String nom, int nivel) {
		int hash = hashCode(nom);
		Par iter = tabla[hash];
		boolean saux = false;
		boolean termina = false;
		while ((iter != null) && (!termina)) {
			if (iter.getValor().getNombre().equals(nom)
					&& iter.getValor().getNivel() == nivel) {
				termina = true;
				saux = true;
			} else if (iter.getValor().getNivel() < nivel) {
				termina = true;
			}
			iter = iter.getSiguiente();
		}
		return saux;
	}

	public void eliminarNivel(int nivel) {
		for (int i = 0; i < tamaño; i++) {
			Par iter = tabla[i];
			boolean termina = false;
			boolean encontrado = false;
			while ((iter != null) && (!termina)) {
				if(iter.getValor().getNivel()<nivel){
					termina=true;							
				}else if(iter.getValor().getNivel()==nivel){
					//System.out.println("Elimino simbolo: "+ iter.getValor().getNombre()+" en el nivel:"+ iter.getValor().getNivel());
					iter = iter.getSiguiente();	
					encontrado = true;
					
				}else{
					System.err.println("Caso imposible: Fallo de algun tipo");
				}
				
			}
			if(encontrado){
				tabla[i]=iter;
			}
		}
		for (int i = 0; i < tamaño; i++) {
			Par iter = tabla[i];
			while (iter != null) {
				//System.out.println("Hay "+ iter.getValor().getNombre()+" en el nivel:"+ iter.getValor().getNivel());
				iter = iter.getSiguiente();	
			}
			
		}
	}
}
