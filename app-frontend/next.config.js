/** @type {import('next').NextConfig} */
const nextConfig = {
	env: {
		loginUrl: 'http://localhost:8080/oauth2/authorization/auth0',
		logoutUrl: 'http://localhost:8080/logout',
	},
	images: {
		remotePatterns: [
			{
				protocol: "https",
				hostname: "*.googleusercontent.com",
				port: "",
				pathname: "/a/**",
			}
		],
	},
};

module.exports = nextConfig
