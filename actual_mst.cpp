#include <bits/stdc++.h>
using namespace std;

//#pragma GCC optimize("Ofast")
//#pragma GCC target("sse,sse2,sse3,ssse3,sse4,popcnt,abm,mmx,avx,tune=native")
//#pragma GCC optimize("unroll-loops")

#define pb push_back
#define mp make_pair
#define sz(a) (ll)(a).size()
#define all(a) a.begin(), a.end()
#define ff first
#define ss second
#define endl "\n"

#include <ext/pb_ds/assoc_container.hpp> // Common file
#include <ext/pb_ds/tree_policy.hpp> // Including tree_order_statistics_node_update

using namespace __gnu_pbds;
typedef tree<int,null_type,less<int>,rb_tree_tag,tree_order_statistics_node_update> pbds;
//K-th smallest
//cout << k << "rd smallest: " << *A.find_by_order(k-1) << endl;
//NO OF ELEMENTS < X
//cout << "No of elements less than " << X << " are " << A.order_of_key(X) << endl;

// priority_queue <ll,vector<ll>,greater<ll> > p;

typedef long long ll;
typedef pair<ll,ll> pii;

ll mod=1000000007;

ll power(ll x, ll y) 
{
	ll temp;
	if( y == 0)
		return 1;
	temp = power(x, y/2);
	if (y%2 == 0)
		return (temp*temp)%mod;
	else
		return (((x*temp)%mod)*temp)%mod; 
}

vector<pair<ll,pii>> edges;
vector<ll> p(100005,-1);
vector<ll> d(100005,1);

ll parent(ll v)
{
	if(p[v]==-1 || p[v]==v)
		return v;
	p[v]=parent(p[v]);
	return p[v];
}

bool has_cycle(ll u, ll v)
{
	ll x = parent(u);
	ll y = parent(v);
	if(x==y)
		return true;
	if(d[x]<d[y])
	{
		p[x]=y;
		d[y]+=d[x];
	}
	else
	{
		p[y]=x;
		d[x]+=d[y];
	}
	return false;
}

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	ll n,m;
	cin>>n>>m;
	ll i;
	for(i=0;i<m;i++)
	{
		ll u,v,w;
		cin>>u>>v>>w;
		edges.pb(mp(w, mp(u,v)));
	}
	sort(all(edges));
	ll ans=0;
	ll cnt=0;
	for(i=0;i<m;i++)
	{
		ll w=edges[i].ff;
		ll u=edges[i].ss.ff;
		ll v=edges[i].ss.ss;
		if(!has_cycle(u,v))
		{
			// cout<<u<<" "<<v<<endl;
			ans+=w;
			cnt++;
		}
		if(cnt==n-1)
			break;
	}
	if(cnt!=n-1)
		cout<<-1<<endl;
	else
		cout<<ans<<endl;
	return 0;
}