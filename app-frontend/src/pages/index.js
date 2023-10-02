import '../app/globals.css';
import axios from "axios";
import Image from "next/image";
import {useState} from "react";
import user from "../../public/user.png"

export default function Index() {

	const [email, setEmail] = useState('Log in to see your profile...');
	const [name, setName] = useState('John');
	const [avatar, setAvatar] = useState(user);

	async function getUser() {
		try {
			const response = await axios.get('/api/user')

			setEmail(response.data.email)
			setName(response.data.name)
			setAvatar(response.data.avatar)

		} catch (error) {
			console.error("User not logged in");
		}
	}

	getUser();

	return (
			<div className="h-screen bg-blue-500 pt-20">
				<div className='mx-auto p-10 rounded-md bg-white w-1/2 max-w-2xl'>
					<p className='text-3xl mb-10'>Enterprise Spring boot Gateway App</p>

					<div className='flex gap-4 items-center'>
						<Image className='rounded-full' width={100} height={100} alt={''} src={avatar}/>
						<div>
							<p className='text-xl'>{name}</p>
							<p className='text-lg'>{email}</p>
						</div>
					</div>

          <div className='flex gap-4 mt-10'>
            <a className='bg-blue-500 hover:bg-blue-700 px-8 py-2 text-xl text-white rounded-md'
               href={process.env.loginUrl}>
              Login
            </a>
						<form method="post" action={process.env.logoutUrl}>
							<button className="bg-blue-500 hover:bg-blue-700 px-8 py-2 text-xl text-white rounded-md" type="submit">Log Out</button>
						</form>
          </div>

				</div>
			</div>
	)
}
