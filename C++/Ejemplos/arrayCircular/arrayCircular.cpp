#include <iostream>
#include <cmath>
#include <vector>

using namespace std;

int main()
{
	vector<int> circular = {10,20,30,40,50};
	int ic = 0, ant, pos;

	for (const auto &value: circular) std::cout << value << ' ';
	cout << endl;

	for(int i = 0; i < 50; i++, ++ic)
	{
		if(ic == 5)
			ic = 0;

		ant = (ic-1) - 5 * ((int)floor((double)(ic - 1) / 5));
		pos = (ic + 1) % 5;
		cout << "indices circular: " << ic << ", ant: " << ant << ", pos: " << pos << endl;
		
		cout << "Anterior: " << circular[ant] << " & Posterior: " << circular[pos] << endl;
	}

	return 0;
}
